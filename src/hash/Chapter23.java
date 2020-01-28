package hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 两个数组的交集
 */
public class Chapter23 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        Set<Integer> hashSet1 = new HashSet<Integer>();
        Set<Integer> hashSet2 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++){
            hashSet1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            if (hashSet1.contains(nums2[i])){
                hashSet2.add(nums2[i]);
            }
        }
        int[] res = new int[hashSet2.size()];
        int index = 0;
        Iterator iterator = hashSet2.iterator();
        while(iterator.hasNext()){
            res[index++] = (int)iterator.next();
        }
        return res;
    }


}
