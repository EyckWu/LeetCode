package hash;

import java.util.HashMap;

/**
 * 存在重复元素2
 */
public class Chapter36 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return false;
        }
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (indexMap.containsKey(nums[i])){
                if (i - indexMap.getOrDefault(nums[i], -1) <= k){
                    return true;
                }
            }
            indexMap.put(nums[i], i);
        }
        return false;
    }

}
