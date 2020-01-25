package arrays_and_string;


import utils.Log;

/**
 * 移动零
 */
public class Chapter56 {

    public static void main(String[] args){
        Chapter56 chapter56 = new Chapter56();
        int[] nums = {0,1,0,3,12};
        chapter56.moveZeroes(nums);
        Log.d(nums);
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int left =  0;
        int right = 0;
        while(right < nums.length){
            if (nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            } else {
                right++;
            }
        }
    }

}
