package Arrays;
import java.util.Scanner;

public class Largest_of_Numbers {
    public static int[] takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        int i = 0;
        while (i < n){
            System.out.print("Enter element at " + i + " th index number: ");
            arr[i] = sc.nextInt();
            i++;
        }
        return arr;
    }
    public static int largest(int arr[]){
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i < arr.length){
            if (arr[i] > max){
                max = arr[i];
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = takeInput();
        int largestNumber = largest(arr);
        System.out.println("Largest number: " + largestNumber);
    }
}
