package comp1110.lectures.A06;

import comp1110.lectures.A04.Set;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public abstract class MapTest {
    public abstract <K extends Comparable<K>, V> Map<K, V> createMap();

    @Test
    public void testPut() {
        Map<String, Double> map = createMap();
        assertEquals(0, map.size());
        assertNull(map.put("apple", 4.00));
        assertEquals(1, map.size());
        assertNull(map.put("banana", 3.00));
        assertEquals(2, map.size());
        assertNull(map.put("mango", 8.00));
        assertEquals(3, map.size());
        checkKeys(map, new String[]{"apple", "banana", "mango"});
    }

    @Test
    public void testPutKeyNull() {
        Map<String, Double> map = createMap();
        assertThrows(IllegalArgumentException.class, () -> map.put(null, 1.00));
    }

    @Test
    public void testPutValueNull() {
        Map<String, Double> map = createMap();
        assertThrows(IllegalArgumentException.class, () -> map.put("kiwifruit", null));
    }

    @Test
    public void testGet() {
        Map<String, Double> map = createMap();
        map.put("apple", 4.00);
        map.put("banana", 3.00);
        map.put("mango", 8.00);
        assertEquals(4.00, map.get("apple"));
        assertEquals(3.00, map.get("banana"));
        assertEquals(8.00, map.get("mango"));
        assertNull(map.get("passionfruit"));
    }

    @Test
    public void testGetKeyNull() {
        Map<String, Double> map = createMap();
        assertThrows(IllegalArgumentException.class, () -> map.get(null));
        map.put("apple", 4.00);
        assertThrows(IllegalArgumentException.class, () -> map.get(null));
    }

    @Test
    public void testUpdateValue() {
        Map<String, Double> map = createMap();
        assertEquals(0, map.size());
        assertNull(map.put("apple", 4.00));
        assertEquals(1, map.size());
        assertEquals(4.00, map.get("apple"));
        assertEquals(4.00, map.put("apple", 6.00));
        assertEquals(1, map.size());
        assertEquals(6.00, map.get("apple"));
        checkKeys(map, new String[]{"apple"});
    }

    @Test
    public void testRemove() {
        Map<String, Double> map = createMap();
        map.put("apple", 4.00);
        map.put("banana", 3.00);
        map.put("mango", 8.00);
        assertEquals(3, map.size());
        assertTrue(map.remove("banana"));
        assertEquals(2, map.size());
        assertFalse(map.remove("coconut"));
        assertEquals(2, map.size());
        checkKeys(map, new String[]{"apple", "mango"});
    }

    @Test
    public void testRemoveLarge() {
        Map<String, Double> map = createMap();
        for (int i = 0; i < 1000; i++) {
            map.put(String.valueOf(i), Double.valueOf(i));
        }
        assertEquals(1000, map.size());
        assertTrue(map.remove("42"));
        assertEquals(999, map.size());
        assertTrue(map.remove("43"));
        assertEquals(998, map.size());
    }

    @Test
    public void testRemoveKeyNull() {
        Map<String, Double> map = createMap();
        assertThrows(IllegalArgumentException.class, () -> map.remove(null));
        map.put("apple", 4.00);
        assertThrows(IllegalArgumentException.class, () -> map.remove(null));
    }

    private void checkKeys(Map<String, Double> map, String[] expected) {
        Set<String> set = map.getKeys();
        Object[] actual = set.toArray();
        Arrays.sort(actual);
        Arrays.sort(expected);
        assertArrayEquals(expected, actual);
    }
}
