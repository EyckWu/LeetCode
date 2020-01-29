package hash;

import utils.Log;

import java.util.HashMap;

/**
 * 同构字符串
 */
public class Chapter32 {

    public static void main(String[] args){
        new Chapter32().isIsomorphic("ab", "aa");
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()){
            return false;
        }
        if (s.isEmpty() && t.isEmpty()){
            return true;
        }
        // 注意基本类型转换可能导致的空指针。eg : null -> char会导致空指针
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++){
            if (!hashMap.containsKey(s.charAt(i))){
                if (hashMap.containsValue(t.charAt(i))){
                    return false;
                }
                hashMap.put(s.charAt(i), t.charAt(i));
            } else {
                if (hashMap.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
