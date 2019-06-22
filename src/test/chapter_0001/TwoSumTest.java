package test.chapter_0001; 

import chapter_0001.TwoSum;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Arrays;

/** 
* TwoSum Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 22, 2019</pre> 
* @version 1.0 
*/ 
public class TwoSumTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: twoSum(int[] nums, int target) 
* 
*/ 
@Test
public void testTwoSum() throws Exception {
    int[] nums = new int[]{2, 7, 11, 15};
    int target = 9;
    int[] result = new int[]{0, 1};
    assert Arrays.equals(new TwoSum().twoSum(nums, target),result);
} 


} 
