package arrays_and_string;

import utils.Log;

/**
 * 删除排序数组中的重复项
 */
public class Chapter55 {
    private static final String TAG = "Chapter55";

    public static void main(String[] args){
        Chapter55 chapter55 = new Chapter55();
        int[] nums = {1,1,2};
        int length = chapter55.removeDuplicates(nums);
        for (int i = 0; i < length; i++){
            Log.d(TAG, "main: " + nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int last = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (last != nums[i]){
                nums[res++] = nums[i];
                last = nums[i];
            }
        }
        return res;
    }

}
