package comp1110.lectures.J07;

public class Methods {

    static void boo() {
        System.out.println("Boo!");
    }

    static void updateArray(int[] a) {
        if (a[0] > 100) return;
        a[0] = 42;
        Methods.boo();
        int[] b = {10, 11, 12};
        a = b;
        a[0] = 100;
    }

    static int addOne(int i) {
        return i + 1;
    }

    static String addOne(String i) {
        return i + "1";
    }

    public static void main(String[] args) {
        System.out.println("Start of main method");

        Methods.boo();
        Methods.boo();
        Methods.boo();

        int[] a = {0, 1, 2, 3};
        for (int v : a) {
            System.out.println("before " + v);
        }

        Methods.updateArray(a);
        for (int v : a) {
            System.out.println("after " + v);
        }

        int z = 15;
        System.out.println("before z = " + z);
        z = Methods.addOne(z);
        System.out.println("after z = " + z);

        String x = "Capital";
        x = Methods.addOne(x);
        System.out.println(x);

        System.out.println("End of main method");
    }
}
