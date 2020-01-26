package listnode;

/**
 * 旋转链表
 */
public class Chapter45 {

    /**
     * 向右旋转，可利用双指针，快指针比慢指针快 k 步，把链表成环，那么慢指针的下一个节点就是新的 head, 从慢指针和新的head节点断开即为旋转的链表。
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while(fast != null){
            fast = fast.next;
            length++;
        }
        fast = head;
        k %= length;
        int index = 0;
        while(fast.next != null){
            if (index >= k){
                slow = slow.next;
            }
            fast = fast.next;
            index++;
        }
        // 成环
        fast.next = head;
        // 定位新head
        head = slow.next;
        // 解环
        slow.next = null;
        return head;
    }

}
