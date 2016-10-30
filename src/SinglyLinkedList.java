/*
 * This is largerly the same as the book example, with the added
 * removeLast function for when the list reaches its capacity
*/
public class SinglyLinkedList<E>
{
    //Node definition
    private static class Node<E>{
        private E element;
        private Node<E> next;
        
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }//end ctor
        
        public E getElement(){
            return element;
        }//end getElement
        
        public Node<E> getNext(){
            return next;
        }//end getNext
        
        public void setNext(Node<E> n){
            next = n;
        }//end setNext
    }//end of Node
    
    //rest of SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    //accessor / observer methods
    public int size() { 
        return size; 
    }//end size
    
    public boolean isEmpty(){
        return size == 0;
    }//end isEmpty
    
    public E first(){
        if(isEmpty()){
            return null;
        }
        return head.getElement();
    }//end first
    
    public E last(){
        if(isEmpty()){
            return null;
        }
        return tail.getElement();
    }//end last
    
    //mutator / transformer methods
    public void addFirst(E e){
        head = new Node<>(e, head);
        if(size == 0){
            tail = head;
        }
        size++;
    }//addFirst
    
    public void addLast(E e){
        Node<E> newest = new Node<>(e,null);
        if(isEmpty()){
            head = newest;
        }
        else{
            tail.setNext(newest);
        }
        
        tail = newest;
        size++;
    }//end addLast
    
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        
        E answer = head.getElement();
        
        head = head.getNext();
        size--;
        
        if(size == 0){
            tail = null;
        }
        
        return answer;
    }//end removeFirst
    
    /*
     * We need this function since we push to the beginning of the stack
     * and we must be able to chop off the end to add more at the beginning
    */
    public E removeLast() {
        if(isEmpty()) {
            return null;
        }
        
        E answer = tail.getElement();
        
        /*
         * Loop through the nodes in the linked list until we reach the
         * second to last
        */
        Node<E> node = head;
        while(node.next != tail) {
            node = node.next;
        }
        
        /*
         * Make the penultimate node the new tail
        */
        node.next = null;
        tail = node;
        size--;
        
        return answer;
        
    }
    
    public void printList() {
        Node<E> walker = head;  //Walker:  Texas Ranger
        
        while(walker != null){
            System.out.println(walker.getElement());
            walker = walker.getNext();
        }
    }//end printList
}
