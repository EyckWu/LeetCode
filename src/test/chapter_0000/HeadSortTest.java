package test.chapter_0000;

import chapter_0000.HeadSort;
import chapter_0000.ISortArray;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * HeadSort Tester.
 *
 * @author <Authors name>
 * @since <pre>���� 13, 2019</pre>
 * @version 1.0
 */
public class HeadSortTest {

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
        ISortArray headSort = new HeadSort();
        int[] result = headSort.sort(sourceArray);
        System.out.println("result:" + Arrays.toString(result));
    }


    /**
     *
     * Method: buildMaxHead(int[] arr, int len)
     *
     */
    @Test
    public void testBuildMaxHead() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = HeadSort.getClass().getMethod("buildMaxHead", int[].class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: heapify(int[] arr, int i, int len)
     *
     */
    @Test
    public void testHeapify() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = HeadSort.getClass().getMethod("heapify", int[].class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: swap(int[] arr, int i, int j)
     *
     */
    @Test
    public void testSwap() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = HeadSort.getClass().getMethod("swap", int[].class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
