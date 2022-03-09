package PriorityQueue;
import java.util.PriorityQueue;

public class InBuiltPriorityQueue {
    public static void main(String[] args) {

        int[] arr = {4,3,7,6,9,10,1,2};
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // byDefault min Priority Queue

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        System.out.println(pq);
//        System.out.println(pq.peek());
        while (!pq.isEmpty()){
            System.out.print(pq.peek() + " ");
            pq.poll();
            System.out.println(pq);
        }

    }
}
