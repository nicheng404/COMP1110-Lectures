package comp1110.lectures.J10;

public class Boxing {
    public static void main(String[] args) {
        // this would work with Short, Long, Float, Double, Character (char)
        Integer a = new Integer(6); // deprecated - creates a brand new object Integer.valueOf(6)
        Integer b = 6; // autoboxing

        Object z = a;
        Integer y = (Integer) z;

        int c = y; // un-boxing
        int d = new Integer(6);

        Integer[] arrayOfInteger = new Integer[100]; // expensive to store
        int[] arrayOfInt = new int[100]; // cheap to store

        if (a == b) {
            System.out.println("a(" + a + ") == b(" + b + ")");
        } else {
            System.out.println("a(" + a + ") != b(" + b + ")");
        }

        if (a.equals(b)) {
            System.out.println("a(" + a + ") equals b(" + b + ")");
        } else {
            System.out.println("a(" + a + ") does not equal b(" + b + ")");
        }
    }
}
