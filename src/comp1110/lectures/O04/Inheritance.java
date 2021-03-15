package comp1110.lectures.O04;

public class Inheritance {
    public static void main(String[] args) {
        Human jane = new Human("Jane");

        Human jane2 = new Human("Jane");
        System.out.println("are the Janes equals? " + jane.equals(jane2));

        Animal[] animals = new Animal[]{
                jane,
                new Snake("Simon")
        };

        for (Animal a : animals) {
            if (a instanceof Reptile) {
                System.out.println(a + " who is a scary reptilian overlord");
                ((Reptile) a).layEgg();
            } else {
                System.out.println(a);
            }
            System.out.println(a.hashCode());
        }

        System.out.println("number of species = " + Animal.getNumberOfSpecies());
        System.out.println("number of species = " + Mammal.getNumberOfSpecies());
    }
}
