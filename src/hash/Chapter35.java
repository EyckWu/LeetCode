package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 两个数组的交集2
 */
public class Chapter35 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++){
            countMap.put(nums1[i], countMap.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++){
            if (countMap.containsKey(nums2[i])){
                if (countMap.getOrDefault(nums2[i], 0) > 0){
                    res.add(nums2[i]);
                    countMap.put(nums2[i], countMap.getOrDefault(nums2[i], 0) - 1);
                }
            }
        }
        int[] resInt = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            resInt[i] = res.get(i);
        }
        return resInt;
    }
}
