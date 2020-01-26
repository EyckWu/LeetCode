package listnode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 环形链表2
 */
public class Chapter22 {

    public static void main(String[] args){
        
    }


    /**
     * 哈希表
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        Object object = new Object();
        HashMap<ListNode, Object> listNodeMap = new HashMap<ListNode, Object>();
        ListNode node = head;
        while(node != null){
            if (listNodeMap.containsKey(node)){
                return node;
            } else {
                listNodeMap.put(node, object);
                node = node.next;
            }
        }
        return null;
    }

    /**
     * 分两个步骤，首先通过快慢指针的方法判断链表是否有环；接下来如果有环，则寻找入环的第一个节点。
     * 具体的方法为，首先假定链表起点到入环的第一个节点A的长度为a【未知】，到快慢指针相遇的节点B的长度为（a + b）【这个长度是已知的】。
     * 现在我们想知道a的值，注意到快指针p2始终是慢指针p走过长度的2倍，所以慢指针p从B继续走（a + b）又能回到B点，如果只走a个长度就能回到节点A。
     * 但是a的值是不知道的，解决思路是曲线救国，注意到起点到A的长度是a，那么可以用一个从起点开始的新指针q和从节点B开始的慢指针p同步走，相遇的地方必然是入环的第一个节点A。
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head){
        ListNode bNode = hasCycle(head);
        if (hasCycle(head) == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = bNode;
        while(fast != null && slow != null){
            if (fast == slow){
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }

    public ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != null && fast != null && fast.next != null){
            if (slow == fast){
                return fast;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return null;
    }
}
