package Queues;

public class Queue_Use {
    public static void main(String[] args) throws QueueEmptyException, QueueFullException {

//        Queues_Using_Arrays queue = new Queues_Using_Arrays(4); // using arrays
        Queues_Using_Arrays queue = new Queues_Using_Arrays();

//        Queue_Using_LL<Integer> queue =  new Queue_Using_LL<>(); // using Linked List

//        int[] arrN = {1,3,5,7,9};
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

//        for (int k :
//                arrN) {
//            queue.enqueue(k);
//        }

        System.out.println(queue.front());
        System.out.println(queue.size());

        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }

//        while (!queue.isEmpty()){
//            System.out.println(queue.dequeue());
//        }

    }
}
