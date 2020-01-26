package listnode;

/**
 * 删除链表的倒数第N个节点
 */
public class Chapter24 {

    public static void main(String[] args){
        Chapter24 chapter24 = new Chapter24();
    }

    /**
     * 三指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        int index = 0;
        while(fast != null){
            if (index >= n){
                if (slow != head){
                    prev = prev.next;
                }
                slow = slow.next;
            }
            fast = fast.next;
            index++;
        }
        if (slow == head){
            head = head.next;
        } else {
            prev.next = slow.next;
        }
        return head;
    }

    /**
     * 递归法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        return removeNode(head, n) == n ? head.next : head;
    }

    public int removeNode(ListNode node, int n){
        if (node.next == null){
            return 1;
        }
        int  m = removeNode(node.next, n);
        if (m == n){
            if (m == 1){
                node.next = null;
            } else {
                node.next = node.next.next;
            }
        }
        return m + 1;
    }

}
