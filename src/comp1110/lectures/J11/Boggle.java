package comp1110.lectures.J11;

import java.util.Random;

public class Boggle {
    static final String[] DICE = {"AJBBOO", "AFFPSK", "ANEAGE", "APSHCO", "QNUMHI", "ZNHRLN", "TDSTYI", "TTWOOA", "TLRYET", "TUMIOC", "EDVLRY", "EDRLXI", "EEGNHW", "EIOTSS", "ERHTWV", "EENUSI"};

    static final int ROW_LENGTH = 4;

    public static void main(String[] args) {
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
            result.append(faceChar);
            if (i % ROW_LENGTH == ROW_LENGTH - 1) result.append(System.lineSeparator());
        }
        System.out.println(result.toString());
    }
}
