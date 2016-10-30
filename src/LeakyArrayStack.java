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
public class LeakyArrayStack<E> implements LeakStack<E> {
    
    /* Default capacity */
    private static final int CAPACITY = 1000;
    private E[] data;
    
    /* ptr keeps track of the current top of the stack
     * elements keeps track of how full the stack is, 
     * and has a max value of the array size
    */
    private int ptr = 0;
    private int elements = 0;
    
    /* Constructors */
    public LeakyArrayStack() {
        /* Default capacity case */
        this(CAPACITY);
    }
    
    public LeakyArrayStack(int capacity) {
        /* Capacity provided case */
        data = (E[])new Object[capacity];
    }
    /* End constructors */
    
    @Override
    public int size() {
        /* elements keeps track of how many values on our stack */
        return elements;
    }
    
    @Override
    public boolean isEmpty() {
        /* If there are zero elements, our stack is empty */
        return elements == 0;
    }
    
    @Override
    public void push(E e) {
        /* ptr % data.length always will yield the current push location
         * in a circular array, so we don't need to bother resetting ptr
         * every time it reaches the maximum capacity, just keep incrementing
        */
        data[ptr++ % data.length] = e;
        
        /* Only increment elements if it has not reached capacity yet */
        if (elements < data.length) {
            elements++;
        }
    }
    
    @Override
    public E top() {
        /* Return (but don't remove) the top value */
        return data[(ptr - 1) % data.length];
    }
    
    @Override
    public E pop() {
        if(!isEmpty()) {
            /* Decrement number of elements and pop the top value, decrementing
             * ptr, we don't need to set the value to null, because the elements
             * variable will never allow us to retrieve the value there, but it
             * can be overwritten by pushing more to the stack
            */
            elements--;
            return data[--ptr % data.length];
        } else {
            return null;
        }
    }
    
}
