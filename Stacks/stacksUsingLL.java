package Stacks;
import Linked_List_01_DS.Node;

public class stacksUsingLL<T> { // using generics

    private Node<T> head;
    private int size;

            // Constructor
    public stacksUsingLL(){
        head = null;
        size = 0;
    }

    public void push(T element){
        Node<T> newNode = new Node<>(element); // creating a new node
        newNode.next = head;
        head = newNode;

        size = size+1;
    }

    public T top() throws stackEmptyException {
        if (head == null || size == 0){
            stackEmptyException emp = new stackEmptyException();
            throw emp;
        }

        return head.data;
    }

    public T pop() throws stackEmptyException {
        if (head == null || size == 0){
            stackEmptyException emp = new stackEmptyException();
            throw emp;
        }

        T temp = head.data;
        head = head.next;

        size = size-1;
        return temp;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
