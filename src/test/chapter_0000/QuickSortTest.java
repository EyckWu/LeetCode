package test.chapter_0000;

import chapter_0000.ISortArray;
import chapter_0000.QuickSort;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * QuickSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 13, 2019</pre>
 */
public class QuickSortTest {

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
        int[] sourceArray = new int[]{2, 4, 6, 8, 1, 5, 8, 3, 7, 3 ,8, 0};
        ISortArray quickSort = new QuickSort();
        int[] result = quickSort.sort(sourceArray);
        System.out.println("result:" + Arrays.toString(result));
    }


    /**
     * Method: quickSort(int[] arr, int left, int right)
     */
    @Test
    public void testQuickSort() throws Exception {
        //TODO: Test goes here...
        /*
        try {
           Method method = QuickSort.getClass().getMethod("quickSort", int[].class, int.class, int.class);
           method.setAccessible(true);
           method.invoke(<Object>, <Parameters>);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        }
        */
    }

    /**
     * Method: partition(int[] arr, int left, int right)
     */
    @Test
    public void testPartition() throws Exception {
        //TODO: Test goes here...
        /*
        try {
           Method method = QuickSort.getClass().getMethod("partition", int[].class, int.class, int.class);
           method.setAccessible(true);
           method.invoke(<Object>, <Parameters>);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        }
        */
    }

    /**
     * Method: swap(int[] arr, int i, int index)
     */
    @Test
    public void testSwap() throws Exception {
        //TODO: Test goes here...
        /*
        try {
           Method method = QuickSort.getClass().getMethod("swap", int[].class, int.class, int.class);
           method.setAccessible(true);
           method.invoke(<Object>, <Parameters>);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        }
        */
    }

} 
