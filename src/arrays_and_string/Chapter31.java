package arrays_and_string;

import java.util.Arrays;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 二进制求和
 */
public class Chapter31 {
    public static void main(String[] args){
        Chapter31 chapter31 = new Chapter31();
        String a = "1010", b = "1011";
        System.out.println(chapter31.addBinary(a, b));
    }

    public String addBinary(String a, String b){
        StringBuilder result = new StringBuilder();
        int al = a.length() - 1;
        int bl = b.length() - 1;
        int carry = 0;
        while (al >= 0 || bl >= 0){
            int sum = carry;
            if (al >= 0){
                sum += (a.charAt(al) - '0');
                al--;
            }
            if (bl >= 0){
                sum += (b.charAt(bl) - '0');
                bl--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0){
            result.append(1);
        }
        return result.reverse().toString();
    }
}
