package comp1110.lectures.J12;

/**
 * A container that can hold an object of a particular (reference) type.
 * @param <T> type parameter: the type of object that this container can hold
 */
public class GenericHolder<T> {
    static class A {
        @Override
        public String toString() {
            return "This is an instance of A";
        }
    }

    private T value;

    public GenericHolder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public <U> String addToString(U something) {
        return this.toString() + something.toString();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        GenericHolder<Integer> h = new GenericHolder<>(42);
        System.out.println(h);

        GenericHolder<Long> l = new GenericHolder<>(112321l);
        System.out.println(l);

        GenericHolder<Double> d = new GenericHolder<>(1.3);
        System.out.println(d);

        GenericHolder<A> aHolder = new GenericHolder<>(new A());
        System.out.println(aHolder);

        Long bigNumber = 100000000l;
        System.out.println(aHolder.addToString(bigNumber));
    }
}
