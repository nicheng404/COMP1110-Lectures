package comp1110.lectures.O04;

public final class Human extends Mammal {
    public Human(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString() + " who likes dogs";
    }
}
