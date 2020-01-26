package listnode;

/**
 * 反转链表
 */
public class Chapter31 {
    public static void main(String[] args){
        Chapter31 chapter31 = new Chapter31();
    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = head;
        ListNode cur = head;
        while(node.next != null){
            cur = node.next;
            node.next = node.next.next;
            cur.next = head;
            head = cur;
        }
        return head;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur){
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }
}
