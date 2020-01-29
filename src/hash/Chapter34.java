package hash;

import java.util.HashMap;

/**
 * 字符串中的第一个唯一字符
 */
public class Chapter34 {
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()){
            return -1;
        }
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            if (countMap.containsKey(s.charAt(i))){
                countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
            } else {
                countMap.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++){
            if (countMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        if (s == null || s.isEmpty()){
            return -1;
        }
        int[] frep = new int[26];
        for (int i = 0; i < s.length(); i++){
            frep[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if (frep[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
