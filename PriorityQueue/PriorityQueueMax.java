package PriorityQueue;
import java.util.ArrayList;

public class PriorityQueueMax<T> {
    // data members
    private ArrayList<Element<T>> heap;

            // Constructor
    public PriorityQueueMax(){
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> e = new Element<>(value, priority);
        heap.add(e); // added in heap

        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        // In maxHeap, "Parent's Priority > Child's Priority"
        while (childIndex > 0){
            if (heap.get(parentIndex).priority < heap.get(childIndex).priority){ //swap them
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }else {
                return;
            }

        }

    }

    public T getMax(){ // Maximum will always be at the 0th index of heap/ root of the CBtree
        return heap.get(0).value;
    }

    public int removeMax() throws PriorityQueueEmptyException{
        if (isEmpty()){ // If PQ is empty, throw exception
            throw new PriorityQueueEmptyException();
        }
        int removedMax = heap.get(0).priority;// storing the value which is to be removed

        // Bring the last element in heap to the 0th index (1st position), and remove the last element
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        if (heap.size() == 1 || heap.size() == 0){
            return removedMax;
        }

        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        int biggerChildIndex;

        while (rightChildIndex < heap.size()){
            if (heap.get(leftChildIndex).priority > heap.get(rightChildIndex).priority){
                biggerChildIndex = leftChildIndex;
            }else {
                biggerChildIndex = rightChildIndex;
            }

            if (heap.get(parentIndex).priority < heap.get(biggerChildIndex).priority){
                Element<T> temp = heap.get(biggerChildIndex);
                heap.set(biggerChildIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                parentIndex = biggerChildIndex;
                leftChildIndex = 2*parentIndex+1;
                rightChildIndex = 2*parentIndex+2;
            }

        }

        if (heap.get(0).priority < heap.get(1).priority){
            Element<T> temp = heap.get(1);
            heap.set(1, heap.get(0));
            heap.set(0, temp);
        }

        return removedMax;
    }

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
