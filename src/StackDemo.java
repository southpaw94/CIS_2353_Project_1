/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mjestes
 */
public class StackDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        /*
         * Demonstration of array based leaky stack implementation
        */
        System.out.println("---Array based stack implementation---");
        
        /* Instantiate a stack object with 15 spaces */
        LeakyArrayStack<Integer> arrStack = new LeakyArrayStack<Integer>(15);
        
        /* Push 51 values (0 to 50) onto the stack */
        for(int i = 0; i <=50; i++) {
            arrStack.push(i);
        }
        
        /* This will only return 50-41 as our circular stack was instantiated
         * with ten positions, even though we pushed integers 0-50 to the stack
        */
        while(!arrStack.isEmpty()) {
            System.out.println(arrStack.pop());
        }
        
        /* For some nice whitespace */
        System.out.println("");
        
        /*
         * Demonstration of singly linked list based leaky stack implementation
        */
        System.out.println("---Singly linked list based stack implementation---");
        LeakyListStack<Integer> listStack;
        
        /* Create a stack with capacity of 15 */
        listStack = new LeakyListStack<Integer>(15);
        
        /* Push 51 values (0 to 50) onto the stack */
        for(int i = 0; i <= 50; i++) {
            listStack.push(i);
        }
        
        /* Pop and return all the values on the stack */
        while(!listStack.isEmpty()) {
            System.out.println(listStack.pop());
        }
    }
    
}
