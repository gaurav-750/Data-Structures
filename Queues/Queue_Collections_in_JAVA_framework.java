package Queues;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_Collections_in_JAVA_framework {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(14);
        queue.add(15);

        System.out.println(queue.size());
        System.out.println(queue.peek()); // peek just gives the front element. It doesn't removes it from the queue
        System.out.println(queue.size());

        System.out.println(queue.poll()); // poll removes and returns the frontMost element from the queue
        System.out.println(queue.size());

//        System.out.println(queue.size());

    }
}
