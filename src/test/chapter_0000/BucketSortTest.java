package test.chapter_0000;

import chapter_0000.BucketSort;
import chapter_0000.ISortArray;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BucketSortTest {

    @Test
    public void sort() {
        int[] sourceArray = new int[]{2, 4, 6, 8, 1, 5, 8, 3, 7, 3 ,8, 0};
        ISortArray bucketSort = new BucketSort();
        int[] result = bucketSort .sort(sourceArray);
        System.out.println("result:" + Arrays.toString(result));
    }
}