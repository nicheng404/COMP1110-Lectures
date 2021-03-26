package comp1110.lectures.C01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSort {

    public static int[] mergeSort(int[] unsorted) {
        // an empty list or a list of size 1 is already 'sorted'
        if (unsorted.length <= 1) {
            return unsorted;
        }

        // split the list into two sublists and sort them
        var size = unsorted.length;
        var leftSize = size / 2;
        var rightSize = size - leftSize;
        var left = new int[leftSize];
        System.arraycopy(unsorted, 0, left, 0, leftSize);
        var right = new int[rightSize];
        System.arraycopy(unsorted, leftSize, right, 0, rightSize);

        var sortedLeft = mergeSort(left);
        var sortedRight = mergeSort(right);
        // merge the sorted sublists
        var result = new int[unsorted.length];
        int l = 0;
        int r = 0;
        int resultIdx = 0;

        while (l < sortedLeft.length || r < sortedRight.length) {
            if (r >= sortedRight.length || (l < sortedLeft.length && sortedLeft[l] < sortedRight[r])) {
                result[resultIdx++] = sortedLeft[l++];
            } else if (r < sortedRight.length) {
                result[resultIdx++] = sortedRight[r++];
            }
        }
        return result;
    }

    @Test
    public void testSort() {
        int[] unsorted = {16, 1, 12, 43, 41, 0, 19, 25};
        int[] sorted = {0, 1, 12, 16, 19, 25, 41, 43};
        Assertions.assertArrayEquals(sorted, mergeSort(unsorted));
    }

    @Test
    public void testSortEven() {
        int[] unsorted = {16, 1, 12, 43};
        int[] sorted = {1, 12, 16, 43};
        Assertions.assertArrayEquals(sorted, mergeSort(unsorted));
    }

    @Test
    public void testSortOdd() {
        int[] unsorted = {16, 1, 12};
        int[] sorted = {1, 12, 16};
        Assertions.assertArrayEquals(sorted, mergeSort(unsorted));
    }

    @Test
    public void testSortOneElement() {
        int[] unsorted = {47};
        int[] sorted = {47};
        Assertions.assertArrayEquals(sorted, mergeSort(unsorted));
    }

    @Test
    public void testEmpty() {
        int[] unsorted = {};
        int[] sorted = {};
        Assertions.assertArrayEquals(sorted, mergeSort(unsorted));
    }
}
