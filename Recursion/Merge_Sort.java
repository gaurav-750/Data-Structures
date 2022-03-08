package Recursion_02;
import java.util.Scanner;

public class Merge_Sort {

    public static void mergeArray(int[] arr1, int[] arr2, int[] d){
        System.out.println(d.length);
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] <= arr2[j]){
                d[k] = arr1[i];
                i++;
            }else {
                d[k] = arr2[j];
                j++;
            }
            k++;
        }

        if (i < arr1.length){
            while (i < arr1.length){
                d[k] = arr1[i];
                i++;
                k++;
            }
        }

        if (j < arr2.length){
            while (j < arr2.length){
                d[k] = arr2[j];
                j++;
                k++;
            }
        }

        return;
    }

    public static void mergeSort(int[] arr){
        // base case
        if (arr.length <= 1){
            return;
        }
        // Basically, we r dividing the arrays into smaller portions and we r sending them into Merge class
        //  In Merge class, they are being sorted (in ascending order).

        int[] arr1 = new int[arr.length/2];
        int[] arr2 = new int[arr.length - arr1.length];

        for (int i = 0; i < arr1.length; i++){
            arr1[i] = arr[i];
        }

        for (int j = 0; j < arr2.length; j++){
            arr2[j] = arr[j+ arr1.length];
        }

        mergeSort(arr1);
        mergeSort(arr2);

        mergeArray(arr1, arr2, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        mergeSort(arr);

//        System.out.println("Inside Main");
        for (int j = 0; j < arr.length; j++){
            System.out.print(arr[j] + " ");
        }
    }
}
