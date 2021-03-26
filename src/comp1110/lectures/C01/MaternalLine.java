package comp1110.lectures.C01;

public class MaternalLine {
    /**
     * @param n number of generations >= 1 e.g. 1 = mother 2 = grandmother
     * @return a string representation of our maternal ancestor
     * * n generations in the past
     */
    static String maternalAncestor(int n) {
        assert n >= 1;
        if (n == 1) {
            return "mother";
        } else if (n == 2) {
            return "grandmother";
        }
        return "great-" + maternalAncestor(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("My maternal ancestor order 1 is my " + maternalAncestor(1));
        System.out.println("My maternal ancestor order 2 is my " + maternalAncestor(2));
        System.out.println("My maternal ancestor order 3 is my " + maternalAncestor(3));
        System.out.println("My maternal ancestor order 10 is my " + maternalAncestor(10));
    }

}
