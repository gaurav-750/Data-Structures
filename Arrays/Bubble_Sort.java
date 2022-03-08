package Arrays;
import java.util.Scanner;

public class Bubble_Sort {
    public static void bubbleSort(int arr[]){

        int max;
        int biggerLoop = 0;

        while (biggerLoop < arr.length){
            int i = 0; // 1st Element
            int j = 1; // 2nd Element
            while (i < arr.length && j < arr.length){
                if (arr[i] > arr[j]){
                    max = arr[i];
                    arr[i] = arr[j];
                    arr[j] = max;
                }

                for (int value : arr) {
                    System.out.print(value + " ");
                }
                System.out.println();
                i++;
                j++;
            }

            biggerLoop++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases to be run: ");
        int cases = sc.nextInt();

        int g = 0;
        while(g < cases){
            System.out.print("Enter the size of array: ");
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            g++;
            bubbleSort(arr);

            // printing the sorted array:
            for (int elem: arr){
                System.out.print(elem + " ");
            }
        }


    }
}
