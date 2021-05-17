package comp1110.lectures.A06;

import comp1110.lectures.A04.HashSet;
import comp1110.lectures.A04.Set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap<K extends Comparable<K>, V> implements Map<K, V> {
    class KVPair {
        // HashMap$KVPair.class
        K key;
        V value;

        public KVPair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_SIZE = 4;
    private List<KVPair>[] table;
    /**
     * number of keys in the map
     */
    private int size;

    public HashMap(int size) {
        table = new LinkedList[size];
    }

    public HashMap() {
        this(DEFAULT_SIZE);
    }

    @Override
    public V put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("tried to put a null key");
        if (value == null) throw new IllegalArgumentException("tried to put a null value");
        List<KVPair> bucket = getBucket(key);
        for (KVPair kv : bucket) {
            if (key.equals(kv.key)) {
                // we found it!
                V temp = kv.value;
                kv.value = value;
                return temp;
            }
        }
        // we didn't find it
        KVPair kv = new KVPair(key, value);
        bucket.add(kv);
        size++;
        return null;
    }

    /**
     * @param key a key that could be stored in the hashtable
     * @return the bucket in which the element would be stored, if it were
     * contained in the hashtable
     */
    private List<KVPair> getBucket(K key) {
        int hash = key.hashCode();
        int bucketIndex = Math.abs(hash) % table.length; // note: hash could be a negative value
        List<KVPair> bucket = table[bucketIndex];
        if (bucket == null) {
            bucket = new LinkedList<>();
            table[bucketIndex] = bucket;
        }
        return bucket;
    }

    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("tried to get a null key");
        List<KVPair> bucket = getBucket(key);
        for (KVPair kv : bucket) {
            if (key.equals(kv.key)) {
                return kv.value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (key == null) throw new IllegalArgumentException("tried to remove a null key");
        List<KVPair> bucket = getBucket(key);
        boolean wasRemoved = false;
        for (KVPair kv : bucket) {
            if (key.equals(kv.key)) {
                // we found it!
                bucket.remove(kv);
                size--;
                wasRemoved = true;
                break;
            }
        }

        return wasRemoved;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<K> getKeys() {
        Set<K> keys = new HashSet<>();
        int i = 0;
        for (List<KVPair> bucket : table) {
            if (bucket != null) {
                for (KVPair kv : bucket) {
                    keys.add(kv.key);
                }
            }
        }

        return keys;
    }

    /*
    //ConcurrentModificationException if modifying a collection during iteration
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        for (Integer i: integers) {
            integers.remove(i);
        }
    }
     */
}
