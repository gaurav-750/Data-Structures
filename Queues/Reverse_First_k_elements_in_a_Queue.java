package Queues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Reverse_First_k_elements_in_a_Queue {

    public static Queue<Integer> reverseFirstKInQueue(Queue<Integer> queue, int k){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < k){
            stack.add(queue.poll());
            i++;
        }

        Queue<Integer> queue2 = new LinkedList<>();
        while (!queue.isEmpty()){
            queue2.add(queue.poll());
        }

        for (int j = 0; j < k; j++) {
            queue.add(stack.pop());
        }
        while (!queue2.isEmpty()){
            queue.add(queue2.poll());
        }

        return queue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        System.out.print("Enter the size of the queue: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        reverseFirstKInQueue(queue, k);

        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }

    }
}
