package arrays_and_string;

import utils.Log;

/**
 * 反转字符串中的单词3
 */
public class Chapter54 {

    public static void main(String[] args){
        Chapter54 chapter54 = new Chapter54();
        String source = "Let's take LeetCode contest";
        Log.d("main: " + chapter54.reverseWords(source));
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return s;
        int i = 0;
        int j = 0;
        char[] words = s.toCharArray();
        int n = words.length;
        while(j < n){
            while(i < n && words[i] == ' ') i++;
            j = i;
            while(j < n && words[j] != ' ') j++;
            reverseWord(words, i, j - 1);
            i = j;
        }
        return new String(words);
    }

    public void reverseWord(char[] words, int start, int end){
        while(start < end){
            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
    }

}
