package comp1110.lectures.J04;

public class Arrays {
    public static void main(String[] args) {
        double d[]; // declaration
        d = new double[5]; // initialize with 5 elements

        d[0] = 1.0;
        d[4] = 3.2;

        System.out.println(d[0]);
        System.out.println(d[1]);
        System.out.println(d[2]);
        System.out.println(d[3]);
        System.out.println(d[4]);
        d[4] = 3.3;
        System.out.println(d[4]);
        System.out.println("length of array d = " + d.length);

        int i[]; // declaration
        i = new int[5]; // initialize with 5 elements
        i[0] = 42;
        System.out.println(i[0]);
        System.out.println(i[1]);
        System.out.println(i[2]);
        System.out.println(i[3]);
        System.out.println(i[4]);

    }
}
