package Recursion_02;
import java.util.Scanner;

public class FindMinimumInArray {

    public static void findMinInArray(int[] arr, int si, int minTillNow){
        // base case
        if (si == arr.length){
            System.out.println(minTillNow);
            return;
        }

        if (arr[si] < minTillNow){
            minTillNow = arr[si];
        }
        findMinInArray(arr, si+1, minTillNow);

        return;
    }

    // Date: 01-12-2021
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findMinInArray(arr, 0, Integer.MAX_VALUE);
    }
}
