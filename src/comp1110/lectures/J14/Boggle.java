package comp1110.lectures.J14;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Boggle {
    static final String[] DICE = {"AJBBOO", "AFFPSK", "ANEAGE", "APSHCO", "QNUMHI", "ZNHRLN", "TDSTYI", "TTWOOA", "TLRYET", "TUMIOC", "EDVLRY", "EDRLXI", "EEGNHW", "EIOTSS", "ERHTWV", "EENUSI"};

    static final int ROW_LENGTH = 4;

    /**
     * The set of neighbours for each die
     */
    static List<Set<Integer>> neighbours = new ArrayList<Set<Integer>>(DICE.length);

    /**
     * The list of characters in this Boggle game, which is the list of the
     * upward-facing sides of each of the 16 dice.
     */
    char[] boggleCharacters;

    /**
     * The set of all English words in the dictionary.
     */
    Set<String> dictionary;

    /**
     *
     * This code generates the set of neighbours for each die.
     * This will be used in the search to know which dice can be visited
     * from a given die.
     *
     * We assume that the dice are numbered:
     *
     *  0  1  2  3
     *  4  5  6  7
     *  8  9 10 11
     * 12 13 14 15
     *
     * So for example, the neighbours of 0 are 1, 4, and 5;
     * the neighbours of 5 are 0, 1, 2, 4, 6, 8, 9, and 10;
     * the neighbours of 11 are 6, 7, 10, 14, 15.
     */
    static {
        for (int i = 0; i < DICE.length; i++) {
            Set<Integer> neighboursOfI = new HashSet<>();
            int x = i / 4;
            int y = i % 4;
            for (int neighbourX = x - 1; neighbourX <= x + 1; neighbourX++) {
                if (neighbourX >= 0 && neighbourX < ROW_LENGTH) {
                    for (int neighbourY = y - 1; neighbourY <= y + 1; neighbourY++) {
                        if (neighbourY >= 0 && neighbourY < ROW_LENGTH) {
                            int neighbourDieNumber = neighbourX * 4 + neighbourY;
                            if (neighbourDieNumber != i) {
                                neighboursOfI.add(neighbourDieNumber);
                            }
                        }
                    }
                }
            }
            /*
            System.out.println("Neighbours of " + i);
            for (Integer neighbour : neighboursOfI) {
                System.out.println(neighbour);
            }
             */
            neighbours.add(neighboursOfI);
        }
    }

    /**
     * Create a new Boggle game with a list of randomly shaken dice.
     */
    Boggle() {
        boggleCharacters = shake();
        dictionary = processDictionary("assets/dictionary.txt");
    }

    public static void main(String[] args) {
        Boggle boggle = new Boggle();
        boggle.solve();
    }

    /**
     * Solve this Boggle game.
     * Print a set of all the words in the dictionary that can be made
     * using this game's boggleCharacters
     */
    void solve() {
        Set<String> results = new HashSet<>();
        for (int i = 0; i < DICE.length; i++) {
            int start = i;
            boolean[] alreadyVisited = new boolean[DICE.length];
            alreadyVisited[start] = true;
            String prefix = String.valueOf(boggleCharacters[start]);
            findWords(results, start, alreadyVisited, prefix);
        }
        for (String word : results) {
            System.out.println(word);
        }
    }

    /**
     * Recursive function for finding Boggle words.
     * <p>
     * This function starts at a particular die, given a prefix which is the
     * list of letters encountered so far in the current search.
     * <p>
     * If the concatenation of the prefix and the current die leads to a valid
     * word, then the word is added to the results.
     * To continue the search, each of the die's neighbours are visited if they
     * have not already been used in the current search.
     * <p>
     *
     * @param results        the set of valid words found so far
     * @param start          the index of the die this search is to start from
     * @param alreadyVisited an array of boolean indicating whether each character in
     *                       boggleCharacters has already been used in this search
     * @param prefix         the string of characters seen so far in this search
     */
    private void findWords(Set<String> results, int start, boolean[] alreadyVisited, String prefix) {
        // for each neighbouring die
        for (Integer neighbour : neighbours.get(start)) {
            // move to neighbour - check whether already visited
            if (!alreadyVisited[neighbour]) {
                String candidate = prefix + boggleCharacters[neighbour];
                if (candidate.length() >= 3 && dictionary.contains(candidate)) {
                    // this is a real word
                    results.add(candidate);
                }
                alreadyVisited[neighbour] = true;
                // recur
                findWords(results, neighbour, alreadyVisited, candidate);
                alreadyVisited[neighbour] = false;
            }
        }
    }

    Set<String> processDictionary(String filename) {
        Set<String> words = new HashSet<>();
        try {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNext()) {
                String word = s.next().toUpperCase();
                words.add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Found " + words.size() + " words.");
        return words;
    }

    private static char[] shake() {
        char[] boggleDice = new char[16];
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        boolean[] alreadySelected = new boolean[DICE.length];
        for (int i = 0; i < DICE.length; i++) {
            int die = rand.nextInt(DICE.length);
            while (alreadySelected[die]) {
                die = (die + 1) % DICE.length;
                //die = rand.nextInt(dice.length); // could be slow?
            }
            alreadySelected[die] = true;
            int face = rand.nextInt(6);
            char faceChar = DICE[die].charAt(face);
            boggleDice[i] = faceChar;
            result.append(faceChar);
            if (i % ROW_LENGTH == ROW_LENGTH - 1) result.append(System.lineSeparator());
        }
        System.out.println(result.toString());
        return boggleDice;
    }

    @Test
    public void testDictionary() {
        Boggle boggle = new Boggle();
        assertTrue(boggle.dictionary.contains("THIN"));
        assertTrue(boggle.dictionary.contains("ZOOLOGY"));
        assertFalse(boggle.dictionary.contains("ZZZZZZZZ"));
    }

    @Test
    public void testNeighbours() {
        int[] neighboursOfZero = {1, 4, 5};
        Set<Integer> computedZero = neighbours.get(0);
        assertTrue(computedZero.size() == 3);
        for (Integer n : neighboursOfZero) {
            assertTrue(computedZero.contains(n));
        }
    }
}
