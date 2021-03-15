package comp1110.lectures.J09;

import java.util.function.IntPredicate;

public class Lambdas {

    static void printMultiplesOf(int divisor, int[] a) {
        for (int v : a) {
            if (v % divisor == 0) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
    }

    static void printSquares(int[] a) {
        for (int v : a) {
            for (int i = 0; i <= v; i++) {
                if (i * i == v) {
                    System.out.print(v + " ");
                }
            }
        }
        System.out.println();
    }

    static void printMatching(int[] a, IntPredicate predicate) {
        for (int v : a) {
            if (predicate.test(v)) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[42];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        //printMultiplesOf(2, a);
        printMatching(a, x -> (x % 2 == 0));
        //printSquares(a);
        IntPredicate isSquare = x -> {
            for (int i = 0; i <= x; i++) {
                if (i * i == x) {
                    return true;
                }
            }
            return false;
        };
        printMatching(a, isSquare);
    }
}
