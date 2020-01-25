package listnode;


import java.util.LinkedList;

public class MyLinkedList<E> {
    transient int size = 0;
    transient Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        return node(index).value;
    }

    Node node(int index){
        Node x = this.head;
        for (int i = 0; i < index; i++){
            x = x.next;
        }
        return x;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node h = head;
        Node newHead = new Node(val, h);
        this.head = newHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (this.size == 0){
            this.head = new Node(val, null);
        } else {
            Node tail = node(size - 1);
            Node newTail = new Node(val, null);
            tail.next = newTail;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= 0){
            addAtHead(val);
        } else if (index == size){
            addAtTail(val);
        } else if (index < size){
            Node prevSucc = node(index - 1);
            Node newNode = new Node(val, prevSucc.next);
            prevSucc.next = newNode;
            size++;
        }
    }

    public void deleteAtHead(){
        this.head = head.next;
        size--;
    }

    public void deleteAtTail(){
        Node tailNode = node(size - 1);
        tailNode.next = null;
        size--;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        if (index == 0){
            deleteAtHead();
            return;
        }
        if (index == size - 1){
            deleteAtTail();
            return;
        }
        Node prevSucc = node(index - 1);
        prevSucc.next = prevSucc.next.next;
        size--;
    }

    class Node{
        int value;
        Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}
