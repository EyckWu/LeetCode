package hash;

/**
 * 快乐数
 */
public class Chapter24 {

    /**
     * code block
     * //参考英文网站热评第一。这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
     * //如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
     * //两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }while(fast != slow);
        if (fast == 1){
            return true;
        } else {
            return false;
        }
    }

    public int squareSum(int n){
        int sum = 0;
        while(n != 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
