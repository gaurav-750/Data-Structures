package PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class K_Largest_Elements {

            // Approach 01
    public static ArrayList<Integer> kLargestElements(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int elem : arr) { // adding all elements in PriorityQueue
            pq.add(elem);
        }
        System.out.println(pq);

        for (int i = 0; i < arr.length-k; i++) { // removing n-k elements from PriorityQueue
            System.out.println(pq.poll());
        }

        // Now add the greatest 'k' elements to list:
        for (int i = 0; i < k; i++) {
            list.add(pq.poll());
        }
//        System.out.println(list);
        return list;
    }
                    // Approach 02
    /*
        1. Add first k elements in PQueue.
        2. From i=k, till i < arr.length, if the minimum element is less than tha incoming element
            poll out the minimum element, and add the incoming element.
        3. Add all the elements from PQueue to ArrayList.
     */
    public static ArrayList<Integer> largestKElements(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        if (pq.isEmpty()){ // if nothing gets added in queue, i.e k = 0, return null.
            return null;
        }

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }

        }

        for (int elem : pq){
            list.add(elem);
        }

        return list;
    }

    public static ArrayList<Integer> kSmallestNumbers(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int elem: arr){ // adding all elements in PQueue
            pq.add(elem);
        }

        // Now remove k numbers from PQueue, the numbers to be out will be minimum
        // as Internally PQueue is stored as minHeap
        for (int i = 0; i < k; i++) {
            list.add(pq.poll());
        }

        return list;
    }

                    // Approach 2 - 'k' Smallest Elements
    public static ArrayList<Integer> smallestKNumbers(int[] arr, int k) {
        // to implement MaxHeap, syntax is below:
        // in MaxHeap, "Parent's Priority > Child's Priority"
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
//        System.out.println(pq);
        if (pq.isEmpty()){ // if PQueue is Empty, return null
            return null;
        }

        // If there are elements, which are smaller than max element in MaxHeap, remove the max
        // and add the element.
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        System.out.println(pq);
        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()){
            list.add(pq.poll());
        }

        return list;
    }

    public static void main(String[] args) {

        int[] arr = {2,3,9,7,8};
        int k = 0;

        System.out.println(kLargestElements(arr, k));

//        System.out.println(largestKElements(arr, k));

        // Date: 18-10-2021
        // 19:25
                        // Problem 02 - K Smallest numbers
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the size of array: ");
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.print("Enter k: ");
//        int k = sc.nextInt();

//        System.out.println(kSmallestNumbers(arr, k));
        System.out.println(smallestKNumbers(arr, k));
    }
}
