package comp1110.lectures.J03;

public class Booleans {
    public static void main(String[] args) {
        boolean a = true;
        System.out.println("a : " + a);
        boolean b = false;
        System.out.println("b : " + b);
        String s = "tRuE";
        boolean c = Boolean.parseBoolean(s);
        System.out.println("c : " + c);
    }
}
