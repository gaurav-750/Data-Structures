package Queues;
import java.util.LinkedList;
import java.util.Queue;
public class Stacks_Using_Queues<T> {
            // data members
    Queue<T> queue1;
    Queue<T> queue2;

    int front;
    int rear;
    int size;

            // Constructor
    public Stacks_Using_Queues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        front = -1;
        rear = -1;
        size = 0;
    }

            /* --------- Public Functions for Stacks --------- */
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(T element){
        queue1.add(element); // adding element in Queue
        size = size+1;
    }

    public T pop() throws QueueEmptyException{
        if (size == 0){
            // throw error
            throw new QueueEmptyException();
        }
        while (queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        T temp = queue1.peek();

        queue2.add(queue1.poll());
        while (queue2.size() != 1){
            queue1.add(queue2.poll());
        }

        size = size-1; // decrement size by 1
        return temp;
    }

    public T top() throws QueueEmptyException {
        if (size == 0){
            // throw error
            throw new QueueEmptyException();
        }
        while (queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        T temp = queue1.peek();
        queue2.add(queue1.poll());

        while (queue2.size() != 0){
            queue1.add(queue2.poll());
        }

        return temp;
    }

}
