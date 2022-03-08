package Queues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Reverse_Queue {

    public static void reverseQueue(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.add(queue.poll());
        }

        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }

                // Recursive Solution :
    public static void reverseQueueRecursively(Queue<Integer> queue){
        // base case
        if (queue.size() <= 1){
            return;
        }

        int front = queue.poll();
        reverseQueueRecursively(queue);

        queue.add(front);
        return;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Enter the size of the queue: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) { // taking input for queue
            queue.add(sc.nextInt());
        }

//        reverseQueue(queue);

        reverseQueueRecursively(queue);
        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }

    }
}
