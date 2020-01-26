package listnode;

/**
 * 移除链表元素
 */
public class Chapter32 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            if (cur.val == val){
                if (cur == head){
                    head = head.next;
                    cur = cur.next;
                } else if (cur.next != null){
                    pre.next = cur.next;
                    cur = cur.next;
                } else {
                    pre.next = null;
                    cur = null;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

}
