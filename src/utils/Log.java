package utils;

import java.util.Arrays;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 打印工具类
 */
public class Log {
    public static void d(Object msg){
        System.out.println(msg.toString());
    }

    public static void d(Object[] msgs){
        System.out.println(Arrays.toString(msgs));
    }

    public static void d(char[] c){
        System.out.println(Arrays.toString(c));
    }

    public static void d(int[] i){
        System.out.println(Arrays.toString(i));
    }
}
