package arrays_and_string;

import utils.Log;

/**
 * Created by eyckwu on 2019/7/21
 * Desc : 最长公共前缀
 **/
public class Chapter33 {
    public static void main(String[] args){
        Chapter33 chapter33 = new Chapter33();
        String[] strs = {"flower","flow","flight"};
        Log.d(chapter33.longestCommentPrefix(strs));
        Log.d(chapter33.longestCommentPrefix2(strs));
        String[] strs2 = {"dog","racecar","car"};
        Log.d(chapter33.longestCommentPrefix(strs2));
        Log.d(chapter33.longestCommentPrefix2(strs2));
    }

    /**
     * 横向扫描法
     * @param strs
     * @return
     */
    public String longestCommentPrefix(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(result) != 0){
                result = result.substring(0, result.length() - 1);
                if (result.length() == 0){
                    return "";
                }
            }
        }
        return result;
    }

    /**
     * 纵向扫描法
     * @param strs
     * @return
     */
    public String longestCommentPrefix2(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++){
                if (i == strs[j].length() || c != strs[j].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
