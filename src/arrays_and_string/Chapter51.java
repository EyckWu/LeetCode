package arrays_and_string;

/**
 * 旋转数组
 */
public class Chapter51 {

    public static void main(String[] agrs){
        Chapter51 chapter51 = new Chapter51();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        chapter51.rotate1(nums, 3);
    }

    public void rotate1(int[] nums, int k){
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++){
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    public void rotate2(int[] nums, int k){
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n -1);
    }

    private void reverse(int[] nums, int start, int end) {

    }

}
