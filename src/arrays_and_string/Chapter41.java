package arrays_and_string;

import utils.Log;

/**
 * Created by eyckwu on 2019/7/21
 * Desc : 字符串反转
 **/
public class Chapter41 {
    public static void main(String[] args){
        Chapter41 chapter41 = new Chapter41();
        char[] s = {'h','e','l','l','o'};
        chapter41.reverseString(s);
        Log.d(s);
    }

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1){
            return;
        }
        int start = 0, end = s.length - 1;
        while(start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
