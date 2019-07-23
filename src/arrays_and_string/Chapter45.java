package arrays_and_string;

import utils.Log;

/**
 * Created by eyckwu on 2019/7/24
 * Desc : 最大连续1的个数
 **/
public class Chapter45 {
    public static void main(String[] args){
        Chapter45 chapter45 = new Chapter45();
        int[] nums = {1,1,0,1,1,1,0};
        Log.d(chapter45.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        max = Math.max(max, cur);
        return max;
    }
}
