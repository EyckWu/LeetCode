package arrays_and_string;

import utils.Log;

/**
 * Created by eyckwu on 2019/7/21
 * Desc : 两数之和2
 **/
public class Chapter43 {
    public static void main(String[] args){
        Chapter43 chapter43 = new Chapter43();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        Log.d(chapter43.twoSm(numbers, target));
    }

    public int[] twoSm(int[] numbers, int target){
        int start = 0, end = numbers.length - 1;
        while (start < end){
            if (numbers[start] + numbers[end] == target){
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] < target){
                start++;
            } else {
                end--;
            }
        }
        return new int[2];
    }
}
