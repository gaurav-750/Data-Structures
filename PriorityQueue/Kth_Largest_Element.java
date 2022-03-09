package PriorityQueue;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kth_Largest_Element {

    public static int kthLargestElement(int[] arr, int k){
        PriorityQueue<Integer>  pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        if (pq.isEmpty()){ // if PQueue is empty, return -1
            return -1;
        }

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();

//        System.out.println("Kth largest Element: " + kthLargestElement(arr, k));

        int[] array = {2,3,2,2,4};
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int elem: array){
            pq.add(elem);
        }
        System.out.println(pq);
    }
}
