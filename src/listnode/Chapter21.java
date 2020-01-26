package listnode;

/**
 * 环形链表
 */
public class Chapter21 {

    public static void main(String[] args){

    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != null && fast != null && fast.next != null){
            if (slow == fast){
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }
}
