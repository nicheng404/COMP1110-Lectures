package comp1110.lectures.J05;

public class ControlFlowIfThenElse {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;
        if (a) {
            if (b) {
                System.out.println("a is true and b is true");
            } else {
                System.out.println("a is true and b is false");
            }
        } else {
            if (b) {
                System.out.println("a is false and b is true");
            } else {
                System.out.println("a is false and b is false");
            }
        }

        if (a && b) {
            System.out.println("Both are true");
        } else {
            System.out.println("At least one is false");
        }

        int i = 11;
        if (i > 10) {
            System.out.println("i is greater than 10");
        }

    }
}
