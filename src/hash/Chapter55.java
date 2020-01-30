package hash;

import java.util.*;

/**
 * 前 K 个高频元素
 */
public class Chapter55 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (countMap.containsKey(nums[i])){
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o1) - countMap.get(o2);
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int key : countMap.keySet()){
            if (pq.size() < k){
                pq.add(key);
            } else if (countMap.get(key) > countMap.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        while (!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }
}
