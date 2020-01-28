package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 */
public class Chapter21 {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1){
            return false;
        }
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (hashSet.contains(nums[i])){
                return true;
            }
            hashSet.add(nums[i]);
        }
        return false;
    }
}
