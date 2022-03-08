package Queues;
import Linked_List_01_DS.Node;

public class Queue_Using_LL<T> {
            // data members :-
    private Node<T> front; // to keep the track of front node of the list
    private Node<T> rear; // to keep the track of rear end of the list
    int size; // to keep the track of the size of the list

            // Constructor:
    public Queue_Using_LL(){
        front = null;
        rear = null;
        size = 0;
    }

                 /*  --------- Public Functions of Queue --------- */
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(T element){
        Node<T> newNode = new Node<>(element); // to insert an element, first create a new Node
        newNode.data = element;
        size++;
        if (size == 1){
            front = newNode;
            rear = newNode;
            front.next = null;
        }else {
            rear.next = newNode;
            rear = newNode;
            rear.next = null;
        }

    }

    public T front() throws QueueEmptyException{
        if (front == null){
            // throw exception
            throw new QueueEmptyException();
        }
        return front.data;
    }

    public T dequeue() throws QueueEmptyException{
        if (size == 0 || front == null){
           //throw exception;
            throw new QueueEmptyException();
        }
        T temp = front.data;

        front = front.next;
        if (front == null){
            rear = null;
        }
        size--;
        return temp;
    }

}
