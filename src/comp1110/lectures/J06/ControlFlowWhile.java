package comp1110.lectures.J06;

public class ControlFlowWhile {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println("i is " + i);
            i += 2;
        }

        System.out.println("between the loops");

        i = 10;
        do {
            System.out.println("i is " + i);
            i--;
        } while (i <= 5);
    }
}
