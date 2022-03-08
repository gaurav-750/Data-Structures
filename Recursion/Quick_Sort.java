package Recursion_02;
import java.util.Scanner;

public class Quick_Sort {

    public static int partition(int[] arr, int si, int ei){
//        System.out.println("si = " + si + "," + "ei: " + ei);
        int pivotElement = arr[si];
        int smallNumCount = 0;

        int k = si+1;
        while (k <= ei){ // finding count of numbers smaller than pivotElement
            if (arr[k] < pivotElement){
                smallNumCount++;
            }
            k++;
        }

        // placing pivotElement into its correct position
        int temp = arr[si + smallNumCount];
        arr[si + smallNumCount] = pivotElement;
        arr[si] = temp;

        int i = si;
        int j = ei;

        // in this loop, we make sure that every element left to pivotElement is '<' pivotElement
        // also every element right to pivotElement is  pivotElement '<='
        while (i < j){
            if (arr[i] < pivotElement){
                i++;
            }else if (arr[j] >= pivotElement){
                j--;
            }else {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

//         printing the array :
        for (int m = 0; m < arr.length; m++){
            System.out.print(arr[m] + " ");
        }
        System.out.println();

        return si + smallNumCount;
    }

    public static void quickSort(int[] arr, int si, int ei){
        // base case
        if (si >= ei){
            return;
        }

        int pivotIndex = partition(arr, si, ei);

        quickSort(arr, si, pivotIndex-1);
        quickSort(arr, pivotIndex+1, ei);

        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int si = 0;
        int ei = arr.length-1;

        quickSort(arr, si, ei);

//        for (int k = 0; k < arr.length; k++){
//            System.out.print(arr[k] + " ");
//        }

    }
}
