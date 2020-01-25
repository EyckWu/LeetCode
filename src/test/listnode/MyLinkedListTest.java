package test.listnode;

import listnode.MyLinkedList;
import org.junit.Test;
import utils.Log;

public class MyLinkedListTest {

    @Test
    public void testMyLinkedList(){
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        int i = obj.get(1);
        Log.d(i);
        obj.deleteAtIndex(1);
        int j = obj.get(1);
        Log.d(j);
    }

}
