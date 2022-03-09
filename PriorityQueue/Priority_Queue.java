package PriorityQueue;
import java.util.ArrayList;

public class Priority_Queue<T> {

    // data members
    private ArrayList<Element<T>> heap;

    public Priority_Queue(){
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> e = new Element<T>(value, priority);
        heap.add(e);

        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;
// We are implementing minHeap. In case of minHeap, "parent priority < Child Priority"

        while (childIndex > 0) {
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) { // swap them
                Element<T> temp = heap.get(childIndex); //create an object of class Element
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }else {
                return;
            }
        }

    }

    public T getMin() throws PriorityQueueEmptyException { // returns the value of element with minimum priority
        if (isEmpty()){
            throw new PriorityQueueEmptyException();
        }

        return heap.get(0).value;
    }

    // Date: 17-10-2021
    // 15:43
                    // My Code - Remove Minimum()
    public T removeMin() throws PriorityQueueEmptyException {
        if (isEmpty()){ // if heap is empty, throw exception
            throw new PriorityQueueEmptyException();
        }

        T minElement = heap.get(0).value; // minimum element which is to be removed

        // Bringing the last element at 0th index (1st position)
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        int smallerChildIndex;

        while (rightChildIndex < heap.size()) {
            if (heap.get(leftChildIndex).priority < heap.get(rightChildIndex).priority){
                smallerChildIndex = leftChildIndex;
            }else {
                smallerChildIndex = rightChildIndex;
            }

            if (heap.get(parentIndex).priority > heap.get(smallerChildIndex).priority) {
                Element<T> Temp = heap.get(smallerChildIndex);
                heap.set(smallerChildIndex, heap.get(parentIndex));
                heap.set(parentIndex, Temp);

                parentIndex = smallerChildIndex;
                leftChildIndex = 2*parentIndex+1;
                rightChildIndex = 2*parentIndex+2;
            }
        }
        /*
            On case could be where only 2 elements are remaining.
            for eg. 63 21
            Now our previousLoop wont do anything as rightChildIndex (2 in this case) is not less
            than heap.size() (2).
            So for this case we have a single if()..which will take care of this case.
         */
        if (heap.get(0).priority > heap.get(1).priority){
            Element<T> Temp = heap.get(1);
            heap.set(1, heap.get(0));
            heap.set(0, Temp);
        }

        return minElement;
    }

    /*
    public T removeMin() throws PriorityQueueEmptyException {
        if (isEmpty()){ // if heap is empty, throw exception
            throw new PriorityQueueEmptyException();
        }

        T minElement = heap.get(0).value; // minimum element which is to be removed

        // Bringing the last element at 0th index (1st position)
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        int smallerChildIndex;

        while (leftChildIndex < heap.size()){
            smallerChildIndex = parentIndex;
            if (heap.get(leftChildIndex).priority < heap.get(smallerChildIndex).priority){
                smallerChildIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() && (heap.get(rightChildIndex).priority < heap.get(smallerChildIndex).priority)){
                smallerChildIndex = rightChildIndex;
            }

            if (smallerChildIndex == parentIndex){
                break;
            }
            Element<T> Temp = heap.get(smallerChildIndex);
            heap.set(smallerChildIndex, heap.get(parentIndex));
            heap.set(parentIndex, Temp);

            parentIndex = smallerChildIndex;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
        }

        return minElement;
    }
     */

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public void display(){
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i).priority + " ");
        }
        System.out.println();
    }

}
