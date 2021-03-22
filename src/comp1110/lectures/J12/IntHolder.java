package comp1110.lectures.J12;

/**
 * A container that holds an Integer.
 */
public class IntHolder {
    private Integer value;

    public IntHolder(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        IntHolder h = new IntHolder(42);
        System.out.println(h);
    }
}
