package 数组和字符串;

import java.util.Arrays;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 寻找数组中心索引
 * 给定一个整数类型的数组 nums, 请编写一个能够返回数组“中心索引”的方法。
 *
 * 我们是这样定义数组中心索引的： 数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，我们应该返回 -1.如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 */
public class Chapter13 {
    public static void main(String[] args){
        Chapter13 chapter13 = new Chapter13();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(chapter13.pivotIndex(nums));
        int[] nums2 = {1, 2, 3};
        System.out.println(chapter13.pivotIndex(nums2));

    }

    public int pivotIndex(int[] nums){
        int sum = sum(nums);
        for (int i = 0; i < nums.length; i++){
            int[] tmp = Arrays.copyOf(nums, i + 1);
            int tmpSum = sum(tmp);
            if (tmpSum * 2 == sum + nums[i]){
                return i;
            }
        }
        return -1;
    }

    private int sum(int[] nums){
        int sum  = 0;
        if (nums.length == 0){
            return sum;
        }
        for (int num: nums){
            sum += num;
        }
        return sum;
    }
}
