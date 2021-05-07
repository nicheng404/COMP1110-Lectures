package comp1110.lectures.C03;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    int age;
    String givenName;
    String familyName;

    public Person(String givenName, String familyName, int age) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age
                && Objects.equals(givenName, person.givenName)
                && Objects.equals(familyName, person.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, givenName, familyName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person josh = new Person("Josh", "Milthorpe", 42);
        Person josh2 = new Person("Josh", "Milthorpe", 42);

        System.out.println(josh.hashCode());
        System.out.println(josh2.hashCode());
        System.out.println("Are objects equal? " + josh.equals(josh2));

        Set<Person> people = new HashSet<>();
        people.add(josh);
        people.add(josh2);
        System.out.println("Elements in people: ");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
