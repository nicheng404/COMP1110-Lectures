package comp1110.lectures.O02;

import comp1110.lectures.O01.Person;

public class Inheritance {
    public static void main(String[] args) {
        COMP1110Student fred = new COMP1110Student("Fred", 23, "u1234567", 4, 24, 5, 4, 5, 45);
        Grade fredsGrade = fred.getGrade();
        System.out.println(fred + " grade " + fred.getGrade());
        COMP1110Student mary = new COMP1110Student("Mary", 25, "u3233567", 4, 25, 5, 4, 5, 50);
        System.out.println(mary + " grade " + mary.getGrade());

        Person[] people = {fred, mary};

    }
}
