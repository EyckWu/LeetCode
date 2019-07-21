package arrays_and_string;

import utils.Log;

import java.util.Arrays;

/**
 * Created by eyckwu on 2019/7/21
 * Desc : 数组拆分1
 **/
public class Chapter42 {
    public static void main(String[] args){
        Chapter42 chapter42 = new Chapter42();
        int[] nums = {1,4,3,2};
        Log.d(chapter42.arrsyPair(nums));
    }

    public int arrsyPair(int[] nums){
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2){
            sum += nums[i];
        }
        return sum;
    }
}
