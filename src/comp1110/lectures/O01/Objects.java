package comp1110.lectures.O01;

public class Objects {
    public static void main(String[] args) {
        Person mary = new Person("Mary", 22);
        Person fred = new Person("Fred", 24);
        Person[] allThePeople = {mary, fred};
        for (Person p : allThePeople) {
            System.out.println(p);
        }
        fred.happyBirthday();
        System.out.println(fred);
    }
}
