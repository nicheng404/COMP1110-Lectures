package comp1110.lectures.O01;

public class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void happyBirthday() {
        this.age++;
    }

    @Override
    public String toString() {
        return "a Person called " + name + ", aged " + age;
    }
}
