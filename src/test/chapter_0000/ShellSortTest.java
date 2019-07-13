package test.chapter_0000;

import chapter_0000.ISortArray;
import chapter_0000.ShellSort;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * ShellSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 13, 2019</pre>
 */
public class ShellSortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sort(int[] sourceArray)
     */
    @Test
    public void testSort() throws Exception {
        int[] sourceArray = new int[]{2, 4, 6, 8, 1, 5, 8, 3, 7, 3, 8, 0};
        ISortArray shellSort = new ShellSort();
        shellSort.sort(sourceArray);
        System.out.println("sourceArray:" + Arrays.toString(sourceArray));
    }
} 
