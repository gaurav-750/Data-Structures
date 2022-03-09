package PriorityQueue;
import java.util.Scanner;

public class Check_Max_Heap {

    public static boolean checkMaxHeap(int[] arr){
        int n = arr.length;
        int parentIndex;
        int leftChildIndex;
        int rightChildIndex;
        int i = 0;

        // If there are n nodes in heap,
        // Number of Non-leaf Nodes = n/2
        while (i <= (n/2)){
            parentIndex = i;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;

            if (leftChildIndex < n && arr[parentIndex] < arr[leftChildIndex]){
                return false;
            }
            if (rightChildIndex < n && arr[parentIndex] < arr[rightChildIndex]){
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Is Max Heap: " + checkMaxHeap(arr));
    }
}
