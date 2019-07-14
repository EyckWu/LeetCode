package test.chapter_0000;

import chapter_0000.CountSort;
import chapter_0000.ISortArray;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CountSortTest {

    @Test
    public void sort() {
        int[] sourceArray = new int[]{2, 4, 6, 8, 1, 5, 8, 3, 7, 3 ,8, 0};
        ISortArray countSort = new CountSort();
        int[] result = countSort.sort(sourceArray);
        System.out.println("result:" + Arrays.toString(result));
    }
}