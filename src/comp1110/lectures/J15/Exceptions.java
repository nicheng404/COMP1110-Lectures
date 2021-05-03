package comp1110.lectures.J15;

import java.util.Date;

public class Exceptions {
    static class MyException extends Exception {
    }

    private static void exceptionalMethod() throws MyException {
        System.out.println("start of exceptionalMethod()");

        Date d = null;
        try {
            System.out.println(d.toString()); // throws NullPointerException
            int x = 7 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught an arithmetic exception: " + e + " stack trace: ");
            e.printStackTrace(System.out);
        } catch (NullPointerException e) { // bad idea!
            System.out.println("Caught a null pointer exception!");
        } catch (Exception e) {
            System.out.println("Caught an exception!");
        } finally {
            System.out.println("In finally clause");
        }

        if (true) {
            throw new MyException();
        }

        System.out.println("end of exceptionalMethod()");
    }

    public static void main(String[] args) {
        System.out.println("start of main()");
        try {
            exceptionalMethod();
        } catch (MyException e) {
            System.out.println("Caught a MyException!");
        }
        System.out.println("end of main()");
    }
}
