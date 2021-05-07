package comp1110.lectures.A04;

import java.util.LinkedList;

public class HashSet<T> implements Set<T> {
    private static final int DEFAULT_SIZE = 4;
    private LinkedList<T>[] table;
    private int size;

    public HashSet() {
        table = new LinkedList[DEFAULT_SIZE];
    }

    @Override
    public boolean add(T element) {
        if (element == null) return false;
        LinkedList<T> bucket = getBucket(element);
        if (bucket.contains(element)) {
            return false;
        } else {
            bucket.add(element);
            size++;
            return true;
        }
    }

    /**
     * @param element an element that could be stored in the hashtable
     * @return the bucket in which the element would be stored, if it were
     * contained in the hashtable
     */
    private LinkedList<T> getBucket(T element) {
        int hash = element.hashCode();
        int bucketIndex = Math.abs(hash) % table.length; // note: hash could be a negative value
        LinkedList<T> bucket = table[bucketIndex];
        if (bucket == null) {
            bucket = new LinkedList<>();
            table[bucketIndex] = bucket;
        }
        return bucket;
    }

    @Override
    public boolean remove(T element) {
        if (element == null) return false;
        LinkedList<T> bucket = getBucket(element);
        boolean wasRemoved = bucket.remove(element);
        if (wasRemoved) {
            size--;
        }
        return wasRemoved;
    }

    @Override
    public boolean contains(T element) {
        if (element == null) return false;
        LinkedList<T> bucket = getBucket(element);
        return bucket.contains(element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];
        int i = 0;
        for (LinkedList<T> bucket : table) {
            if (bucket != null) {
                for (T element : bucket) {
                    elements[i++] = element;
                }
            }
        }

        return elements;
    }
}
