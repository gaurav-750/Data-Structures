package Recursion_02;
import java.util.Scanner;

public class Binary_Search {

    public static int binarySearch(int[] arr, int si, int ei, int x){
        // base case
        // If start index exceeds end index, that means element is not present in the Array.
        if (si > ei){
            return -1;
        }
                // Calculating Mid Index :
        int midIndex = (si+ei)/2;
//        System.out.println(midIndex);

        // According to conditions, make a recursive call and return answer.
        if (arr[midIndex] == x){
            return midIndex;
        }else if (arr[midIndex] < x){
            int ans = binarySearch(arr, midIndex+1, ei, x);
            return ans;
        }else {
            int ans = binarySearch(arr, si, midIndex-1, x);
            return ans;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        int si = 0;
        int ei = arr.length-1;

        int result = binarySearch(arr, si, ei, x);
        System.out.println(result);

    }
}
