package listnode;

/**
 * 回文链表
 */
public class Chapter34 {

    public static void main(String[] args){

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 找到中点
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 逆序
        ListNode next = null;
        ListNode prev = null;
        while(slow != null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // 比较
        slow = head;
        while(prev != null && slow != null){
            if (prev.val != slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }

}
