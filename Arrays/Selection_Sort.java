package Arrays;
import java.util.Scanner;

// Sorting - Three types of sorting techniques -
        // 1. Selection sort
        // 2. Bubble sort
        // 3. Insertion sort
public class Selection_Sort {
    // Selection sort :-
    public static void selectionSort(int arr[]){
        int n = arr.length;
        int i = 0;
        while (i < n){
            int min = arr[i]; // consider minimum element as arr[i]
            int j = i+1;
            while (j < n){
                if (min > arr[j]){ // if we find an element less than min, swap them
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
                j++;
            }
            for (int elem: arr){
                System.out.print(elem + " ");
            }
            System.out.println();
            i++;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        for(int elem: arr){
            System.out.print(elem + " ");
        }
    }

}
