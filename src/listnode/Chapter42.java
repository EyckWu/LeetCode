package listnode;

/**
 * 两数相加
 */
public class Chapter42 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode cur = null;
        int c = 0;
        while(l1 != null || l2 != null){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + c;
            c = sum / 10;
            if (head == null){
                head = new ListNode(sum % 10);
                cur = head;
            } else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if (c != 0){
            cur.next = new ListNode(c);
        }
        return head;
    }

}
