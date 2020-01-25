package arrays_and_string;

import utils.Log;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 实现strStr()
 */
public class Chapter32 {
    public static void main(String[] args){
        Chapter32 chapter32 = new Chapter32();
        String haystack = "hello", needle = "ll";
        Log.d(chapter32.strStr1(haystack, needle));
    }

    public int strStr(String haystack, String needle){
        if (needle == null || needle.isEmpty()){
            return 0;
        }
        if (haystack == null || haystack.isEmpty()){
            return -1;
        }
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        char targetFirst = needleArray[0];
        int max = haystackArray.length;
        int targetCount = needleArray.length;
        for (int i = 0; i < max; i++){
            if (haystackArray[i] != targetFirst){
                while (++i < max && haystackArray[i] != targetFirst);
            }
            if (i < max){
                int j = i + 1;
                int end = j + targetCount - 1;
                if (end > max) {
                    return -1;
                }
                for (int k = 1; j < end && haystackArray[j] == needleArray[k]; j++,k++);
                if (j == end){
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        if (needle == null || needle.isEmpty()){
            return 0;
        }
        if (haystack == null || haystack.isEmpty()){
            return -1;
        }
        int max = haystack.length();
        int targetCount = needle.length();
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        char firstTarget = needleArray[0];
        for (int i = 0; i < max; i++){
            while(haystackArray[i] != firstTarget && ++i < max);
            Log.d(i);
            if (i < max){
                int j = i + 1;
                int end = j + targetCount - 1;
                if (end > max){
                    return -1;
                }
                for (int k = 1; j < end && haystackArray[j] == needleArray[k]; k++, j++);
                if (j == end){
                    return i;
                }
            }
        }
        return -1;
    }
}
