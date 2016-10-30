/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mjestes
 * @param <E>
 */
public class LeakyListStack<E> implements LeakStack<E> {
    
    public int capacity = 1000;
    
    /* It's final because NetBeans was pestering me with a damn warning */
    private final SinglyLinkedList<E> list;
    
    /*
     * Constructor
    */
    public LeakyListStack(int capacity) {
        list = new SinglyLinkedList<>();
        
        /* Since list capacity is not determined when the list is instantiated
         * We must keep track of it as it grows
        */
        this.capacity = capacity;
    }
    
    /* Returns list size */
    public int size() {
        return list.size();
    }
    
    /* Returns empty status */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void push(E e) {
        if (size() == capacity) {
            /* If capacity reached, truncated end */
            list.removeLast();
        }
        /* Then add new value to beginning */
        list.addFirst(e);
    }
    
    public E top() {
        /* Get front value but don't remove it */
        return list.first();
    }
    
    public E pop() {
        /* Size of list is handled by SinglyLinkedList class 
         * so we don't need to worry about it here, just remove the value
         * from the front and return it
        */
        return list.removeFirst();
    }
}
