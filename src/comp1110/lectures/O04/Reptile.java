package comp1110.lectures.O04;

public abstract class Reptile extends Animal {
    public Reptile(String name) {
        super(name);
    }

    public final void layEgg() {
        System.out.println("I laid an egg!");
    }
}
