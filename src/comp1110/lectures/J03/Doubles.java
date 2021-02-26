package comp1110.lectures.J03;

public class Doubles {
    public static void main(String[] args) {
        double x = 3.1;
        System.out.println(x);
        double w = 1.0 / 3.0;
        System.out.println(w);
        double y = 1.23456e-7; // 0.0000001234567
        System.out.println(y);
        String s = "3.123";
        double z = Double.parseDouble(s);
        System.out.println(z);
    }
}
