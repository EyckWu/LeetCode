package hash;

/**
 * 只出现一次的数字
 */
public class Chapter22 {

    /**
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     *
     * 任何数于0异或为任何数 0 ^ n => n
     *
     * 相同的数异或为0: n ^ n => 0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}
