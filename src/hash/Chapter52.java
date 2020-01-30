package hash;

import java.util.HashMap;

/**
 * 无重复字符的最长字串
 *
 * 这道题主要用到思路是：滑动窗口
 *
 * 什么是滑动窗口？
 *
 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
 *
 * 如何移动？
 *
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
 *
 * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
 *
 * 时间复杂度：O(n)O(n)
 *
 */
public class Chapter52 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }
        HashMap<Character, Integer> windows = new HashMap();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (windows.containsKey(cur)){
                left = Math.max(left, windows.get(cur) + 1);
            }
            windows.put(cur, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
