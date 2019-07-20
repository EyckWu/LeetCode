package 数组和字符串;

import java.util.Arrays;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 加一
 */
public class Chapter15 {
    public static void main(String[] agrs){
        Chapter15 chapter15 = new Chapter15();
        int[] digits = {1, 2, 3};
        System.out.println(Arrays.toString(chapter15.plusOne(digits)));
        int[] digits2 = {9, 9, 9};
        System.out.println(Arrays.toString(chapter15.plusOne(digits2)));
    }

    public int[] plusOne(int[] digits){
        int[] arr = Arrays.copyOf(digits, digits.length);
        if (digits.length == 0){
            return arr;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            if (carry == 0){
                return arr;
            }
            int tmp = arr[i] + carry;
            carry = tmp / 10;
            arr[i] = tmp % 10;
        }
        if (carry != 0){
            int[] arr2 = new int[arr.length + 1];
            System.arraycopy(arr, 0, arr2, 1, arr.length);
            arr2[0] = 1;
            return arr2;
        }
        return arr;
    }
}
