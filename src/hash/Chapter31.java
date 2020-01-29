package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Chapter31 {

    /**
     * 一遍哈希法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1){
            return new int[0];
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('a', 'b');
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
