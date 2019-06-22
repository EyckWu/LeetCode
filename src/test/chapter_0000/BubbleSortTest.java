package test.chapter_0000;

import chapter_0000.BubbleSort;
import chapter_0000.ISortArray;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * BubbleSort Tester.
 *
 * @author <Authors name>
 * @since <pre>���� 22, 2019</pre>
 * @version 1.0
 */
public class BubbleSortTest {

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
        ISortArray bubbleSort = new BubbleSort();
        bubbleSort.sort(sourceArray);
        System.out.println("sourceArray:" + Arrays.toString(sourceArray));
    }


} 
