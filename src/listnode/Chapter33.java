package listnode;

/**
 * 奇偶链表
 */
public class Chapter33 {

    public static void main(String[] args){

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode oddCur = head;
        ListNode evenHead = head.next;
        ListNode evenCur = evenHead;
        while(oddCur.next != null && evenCur.next != null){
            oddCur.next = oddCur.next.next;
            evenCur.next = evenCur.next.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return head;
    }

}
