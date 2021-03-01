package comp1110.lectures.J06;

public class ControlFlowFor {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("i is " + i);
        }

        for (int j = 10; j >= 1; j--) {
            System.out.println("j is " + j);
        }

        int a[] = {3, 5, 7, 11, 13, 17};
        for (int i = 0; i < a.length; i++) {
            System.out.println("element " + i + " of a is " + a[i]);
        }

        for (int v : a) {
            System.out.println("next value is " + v);
        }

        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 10; j >= 8; j--) {
                System.out.println("i == " + i + " j == " + j);
                if (i * j == 9) {
                    System.out.println("i*j == 9, so we break");
                    break outer;
                }
            }
        }

    }
}
