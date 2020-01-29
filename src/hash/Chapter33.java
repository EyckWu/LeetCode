package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 两个列表的最小索引总和
 */
public class Chapter33 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0){
            return new String[0];
        }
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++){
            hashMap.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++){
            if (hashMap.containsKey(list2[i])){
                int j = hashMap.get(list2[i]);
                if (i + j < min){
                    list.clear();
                    list.add(list2[i]);
                    min = i + j;
                } else if (i + j == min){
                    list.add(list2[i]);
                }

            }
        }
        return list.toArray(new String[list.size()]);
    }
}
