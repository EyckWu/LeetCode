package arrays_and_string;

import utils.Log;

/**
 * 翻转字符串里的单词
 */
public class Chapter53 {
    private static final String TAG = "Chapter53";

    public static void main(String[] args){
        Chapter53 chapter53 = new Chapter53();
        chapter53.reverseWords("the sky is blue");
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()){
            return s;
        }
        char[] words = s.toCharArray();
        int n = words.length;
        reverse(words, 0, n - 1);
        reverse_word(words, n);
        return clean_space(words, n);
    }

    public String clean_space(char[] words, int n){
        int i = 0;
        int j = 0;
        while(j < n){
            while(j < n && words[j] == ' '){
                j++;
            }
            while(j < n && words[j] != ' '){
                words[i++] = words[j++];
            }
            while(j < n && words[j] == ' '){
                j++;
            }
            if (j < n){
                words[i++] = ' ';
            }
        }
        return new String(words).substring(0, i);
    }

    public void reverse_word(char[] words, int n){
        int i = 0;
        int j = 0;
        while(j < n){
            // 找到首位置
            while(i < n && words[i] == ' '){
                i++;
            }
            j = i;
            while(j < n && words[j] != ' '){
                j++;
            }
            reverse(words, i, j - 1);
            i = j;
        }
    }

    public void reverse(char[] words, int start, int end){
        while(start < end){
            char temp = words[end];
            words[end] = words[start];
            words[start] = temp;
            start++;
            end--;
        }
    }

}
