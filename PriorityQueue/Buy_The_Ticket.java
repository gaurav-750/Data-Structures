package PriorityQueue;
import java.util.*;

public class Buy_The_Ticket {

    public static int buyTheTicket(int[] arr, int k){
        Queue<Integer> queue = new LinkedList<>();
        // Implementing a Max PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int elem: arr){
            queue.add(elem);
            pq.add(elem);
        }
        if (pq.isEmpty()){
            return -1;
        }

        int countTime = 0;
        int i = 0;

        while (!queue.isEmpty() && !pq.isEmpty()){
            if (k == 0){
                if (queue.peek() >= pq.peek()) {
                    countTime = countTime + 1;
                    return countTime;
                }else {
                    int addLast = queue.poll();
                    queue.add(addLast);
                    k = queue.size()-1;
                }
            }else if (queue.peek() < pq.peek()){
                int addLast = queue.poll();
                queue.add(addLast);
                k--;
            }else if (queue.peek() >= pq.peek()){
                queue.poll();
                pq.poll();
                countTime++;
                k--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the index of My Priority: ");
        int k = sc.nextInt();

        System.out.println("Time required to buy the ticket: " + buyTheTicket(arr, k) + "mins.");
    }
}
