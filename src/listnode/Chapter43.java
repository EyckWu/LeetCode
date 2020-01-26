package listnode;

/**
 * 扁平化多级双向链表
 */
public class Chapter43 {

    public Node flatten(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;
        while(cur != null){
            if (cur.child != null){
                Node next = cur.next;
                Node child = flatten(cur.child);
                child.prev = cur;
                cur.next = child;
                cur.child = null;
                if (next != null){
                    while (cur.next != null){
                        cur = cur.next;
                    }
                    cur.next = next;
                    next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }

}
