package Queues;

public class Queues_Using_Arrays {
        // The data members would be -
    private int[] arr;  // an array where this all implementation is gonna take place
    private int front; // Index of element at front of the queue
    private int rear; // Index of element at Last of the queue
    int size;

            // Constructor (Default) :
    public Queues_Using_Arrays(){
        arr = new int[3];
        front = -1; // initially there's no element in queue, so frontIndex would be -1 (not 0)
        rear = -1;
        size = 0;
    }
            // Constructor (With Initial Capacity) :
    public Queues_Using_Arrays(int capacity){
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == arr.length;
    }

    public void enqueue(int element){ // For inserting element in Queue
        if (size == arr.length){ // if array is full
//            throw new QueueFullException();
            doubleCapacity();
        }
        if (size == 0){
            front = front+1;
            arr[front] = element;
        }else {
//            if (rear == arr.length){
//                rear = -1;
//            }
            arr[rear+1] = element;
        }
        rear = rear+1;
        size++;
    }

    private void doubleCapacity(){ // this should be used internally, hence it's kept private
        int[] temp = arr;
        arr = new int[2*temp.length];

        int index = 0;
        for (int i = front; i < temp.length; i++) {
            arr[index] = temp[i];
            index++;
        }

        for (int j = 0; j < front; j++) {
            arr[index] = temp[j];
            index++;
        }

        front = 0;
        rear = temp.length-1;
    }

    public int front() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }

        return arr[front];
    }

    public int dequeue() throws QueueEmptyException{
        if (size == 0){
            throw new QueueEmptyException();
        }

        int temp = arr[front];
        front = front+1;
        if (front == arr.length){
            front = -1;
        }
        size--;

        if (size == 0){
            front = -1;
            rear = -1;
        }
        return temp;
    }

}
