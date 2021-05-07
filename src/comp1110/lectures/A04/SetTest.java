package comp1110.lectures.A04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class SetTest {
    public abstract <T> Set<T> createSet();

    @Test
    public void testAdd() {
        Set<String> set = createSet();
        assertEquals(0, set.size());
        assertTrue(set.add("Arthur"));
        assertEquals(1, set.size());
        assertTrue(set.add("Trillian"));
        assertEquals(2, set.size());
        String[] expected = new String[]{"Arthur", "Trillian"};
        checkSetContents(set, expected);
    }

    @Test
    public void testAddDuplicate() {
        Set<String> set = createSet();
        assertEquals(0, set.size());
        assertTrue(set.add("Arthur"));
        assertEquals(1, set.size());
        assertFalse(set.add("Arthur"));
        assertEquals(1, set.size());
        String[] expected = new String[]{"Arthur"};
        checkSetContents(set, expected);
    }

    @Test
    public void testAddNull() {
        Set<String> set = createSet();
        assertFalse(set.add(null));
    }

    @Test
    public void testRemove() {
        Set<String> set = createSet();
        assertTrue(set.add("Arthur"));
        assertEquals(1, set.size());
        assertFalse(set.remove("Ford"));
        checkSetContents(set, new String[]{"Arthur"});
        assertEquals(1, set.size());
        assertTrue(set.add("Trillian"));
        assertTrue(set.add("Zaphod"));
        assertTrue(set.add("Ford"));
        assertTrue(set.remove("Arthur"));
        assertEquals(3, set.size());
        String[] expected = new String[]{"Ford", "Trillian", "Zaphod"};
        checkSetContents(set, expected);
    }

    @Test
    public void testContains() {
        Set<String> set = createSet();
        set.add("Arthur");
        assertTrue(set.contains("Arthur"));
        assertFalse(set.contains("Marvin"));
        assertFalse(set.contains(null));
    }

    private void checkSetContents(Set<String> set, String[] expected) {
        Object[] actual = set.toArray();
        Arrays.sort(actual);
        Arrays.sort(expected);
        assertArrayEquals(expected, actual);
    }
}
