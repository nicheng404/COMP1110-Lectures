package comp1110.lectures.O04;

public abstract class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    public static long getNumberOfSpecies() {
        return (long) 1e6;
    }
}
