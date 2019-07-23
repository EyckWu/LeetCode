package arrays_and_string;

import utils.Log;

/**
 * Created by eyckwu on 2019/7/24
 * Desc : 移除元素
 **/
public class Chapter44 {
    public static void main(String[] args){
        Chapter44 chapter44 = new Chapter44();
        int[] nums = {0,1,2,2,3,0,4,2};
        Log.d(chapter44.removeElement(nums, 2));
    }

    public int removeElement(int[] nums, int val){
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
