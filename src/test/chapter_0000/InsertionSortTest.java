package test.chapter_0000;

import chapter_0000.ISortArray;
import chapter_0000.InsertionSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void sort() {
        int[] sourceArray = new int[]{2, 4, 6, 8, 1, 5, 8, 3, 7, 3 ,8, 0};
        ISortArray insertionSort = new InsertionSort();
        insertionSort.sort(sourceArray);
        System.out.println("sourceArray:" + Arrays.toString(sourceArray));
    }
}