package arrays_and_string;

import utils.Log;

/**
 * @author : EyckWu
 * @date : 2019/8/11
 * desc    : 长度最小的子数组
 */
public class Chapter46 {

    public static void main(String[] args){
        Chapter46 chapter46 = new Chapter46();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        Log.d(chapter46.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int s, int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum >= s){
                minLength = Math.min(minLength, i -left + 1);
                sum -= nums[left++];
            }
        }
        return (minLength != Integer.MAX_VALUE) ? minLength : 0;
    }
}
