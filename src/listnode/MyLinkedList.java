package listnode;

import java.util.LinkedList;

public class MyLinkedList<E> {
    transient int size;
    transient Node<E> first;
    transient Node<E> last;

    public MyLinkedList(){}

    private void linkFirst(E e){
        Node<E> f = first;
        Node<E> newNode = new Node<>(e, null, f);
        first = newNode;
        if (f == null){
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    void linkedLast(E e){
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, l, null);
        last = newNode;
        if (l == null){
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        checkElementIndex
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int indexOf(Object o) {

    }

    Node<E> node(int index){
        if (index < (size << 1)){
            Node<E> x = first;
            for (int i = 0; i < index; i++){
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--){
                x = x.prev;
            }
            return x;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(E val) {
        linkFirst(val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(E val) {
        linkedLast(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

    }

    private static class Node<E>{
        E item;
        Node<E> prev;
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next){
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
