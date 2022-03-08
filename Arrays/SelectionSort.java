package Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static int minElementIndex(int[] arr, int si){

        int minElement = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = si; i < arr.length; i++) {
            if (arr[i] < minElement){
                minElement = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void selectionSort(int[] arr){

        int i = 0;
        while (i < arr.length){
            //find the minimum element from the array:
            int minIndex = minElementIndex(arr, i);//passing the start index as well

            //swap the elements: arr[i] <-> arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            i++;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Taking Input:
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        selectionSort(arr);

        //printing the sorted array:
        for (int elem: arr){
            System.out.print(elem + " ");
        }
    }
}
