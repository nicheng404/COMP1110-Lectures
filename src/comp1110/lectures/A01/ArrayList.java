package comp1110.lectures.A01;

public class ArrayList<T> implements List<T> {
    private T[] values;
    private int size;

    public ArrayList() {
        values = (T[]) new Object[1];
    }

    @Override
    public void add(T value) {
        if (size == values.length) {
            // we ran out of room, so double the available storage
            T[] newValues = (T[]) new Object[values.length * 2];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
        values[size++] = value;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        T result = values[index];
        // set the element to null so it can be garbage collected
        // (in case this is the last element in the array)
        values[index] = null;
        // move all subsequent elements down by one to fill the gap
        for (int i = index + 1; i < size; i++) {
            values[i - 1] = values[i];
        }
        size--;
        return result;
    }

    @Override
    public void reverse() {
        // version 1: swap pairs of elements: 0 <-> n-1, 1 <-> n-2, etc.
        // until we reach the middle
        for (int i = 0; i < size / 2; i++) {
            T temp = values[i];
            values[i] = values[size - i - 1];
            values[size - i - 1] = temp;
        }
        /*
        // version 2: copy elements in reverse order into a new array
        T[] newValues = (T[]) new Object[values.length];
        for (int i = size - 1; i >= 0; i--) {
            newValues[size - i - 1] = values[i];
        }
        values = newValues;
        */
    }
}
