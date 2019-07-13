package test.chapter_0000;

import chapter_0000.ISortArray;
import chapter_0000.MergeSort;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * MergeSort Tester.
 *
 * @author <Authors name>
 * @since <pre>���� 13, 2019</pre>
 * @version 1.0
 */
public class MergeSortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: sort(int[] sourceArray)
     *
     */
    @Test
    public void testSort() throws Exception {
        int[] sourceArray = new int[]{2, 4, 6, 8, 1, 5, 8, 3, 7, 3 ,8, 0};
        ISortArray mergeSort = new MergeSort();
        int[] result = mergeSort.sort(sourceArray);
        System.out.println("result:" + Arrays.toString(result));
    }

    /**
     *
     * Method: merge(int[] left, int[] right)
     *
     */
    @Test
    public void testMerge() throws Exception {
//TODO: Test goes here... 
    }


} 
