package comp1110.lectures.O02;

public class COMP1110Student extends Student implements Comparable<COMP1110Student> {
    public static int numberOfStudents; // total number of enrolled students

    private int ass1;
    private int ass2;
    private int ce;
    private int labtest;
    private int mse;
    private int exam;

    static { // static initializer
        COMP1110Student.numberOfStudents = 0;
    }

    { // instance initializer (not necessary for this class)
        this.ass1 = 0;
        this.ass2 = 0;
        this.ce = 0;
    }

    public COMP1110Student(String name, int age, String uid, int ass1, int ass2, int ce, int labtest, int mse, int exam) {
        super(name, age, uid);
        this.ass1 = ass1;
        this.ass2 = ass2;
        this.ce = ce;
        this.labtest = labtest;
        this.mse = mse;
        this.exam = exam;
        COMP1110Student.numberOfStudents++;
    }

    public int redeem(int mark, int max) {
        return Math.max(mark, (max * exam) / 100);
    }

    public int mark() {
        return redeem(ass1, 5)
                + ass2
                + redeem(ce, 5)
                + redeem(labtest, 5)
                + redeem(mse, 5)
                + exam;

    }

    public Grade getGrade() {
        int finalMark = mark();
        Grade finalGrade = Grade.fromMark(finalMark);
        return finalGrade;
    }

    @Override
    public int compareTo(COMP1110Student o) {
        return this.getName().compareTo(o.getName());
    }
}
