package 数组和字符串;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 */
public class Chapter14 {
    public static void main(String[] args){
        Chapter14 chapter14 = new Chapter14();
        int[] nums = {3, 6, 1, 0};
        System.out.println(chapter14.dominantIndexAdvance(nums));
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(chapter14.dominantIndexAdvance(nums2));
    }

    public int dominantIndexAdvance(int[] nums){
        if (nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return 0;
        }
        int max = -1;
        int second = -1;
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second){
                second = nums[i];
            }
        }
        return max >= second * 2 ? index : -1;
    }

    public int dominantIndex(int[] nums){
        if (nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return 0;
        }
        int maxIndex = maxNumIndex(nums);
        for (int i = 0; i < nums.length; i++){
            if (maxIndex != i && nums[maxIndex] < nums[i] * 2){
                return -1;
            }
        }
        return maxIndex;
    }

    private static int maxNumIndex(int[] nums){
        int index = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[index] < nums[i]){
                index = i;
            }
        }
        return index;
    }
}
