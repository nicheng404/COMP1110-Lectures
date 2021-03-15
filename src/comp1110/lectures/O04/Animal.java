package comp1110.lectures.O04;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " is a " + this.getClass().getSimpleName();
    }

    public static long getNumberOfSpecies() {
        return (long) 2e9;
    }
}
