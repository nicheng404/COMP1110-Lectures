package comp1110.lectures.J04;

import java.util.Random;

public class Booleans {
    public static void main(String[] args) {
        boolean a = true;
        System.out.println("a: "+a);
        boolean b = false;
        System.out.println("b: "+b);
        String s = "tRuE";
        boolean c = Boolean.parseBoolean(s);
        System.out.println("c: "+c);

        Random r = new Random();
        boolean d = r.nextBoolean();
        System.out.println("d: "+d);

        System.out.println("and: "+(a && b));
        System.out.println("or: "+(a || b));
        System.out.println("not: "+(!a));
        System.out.println("xor: "+(a ^ b));
    }
}
