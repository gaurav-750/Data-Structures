package Arrays;
import java.util.Scanner;

public class Sort_Use {
    public static void main(String[] args) {
        Sort callSort = new Sort();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        char cont = 'y';
        while (cont == 'y'){
            System.out.print("What Sorting method do you prefer?\n Type 1 for Insertion, 2 for Selection or 3 for Bubble: ");
            int preference = sc.nextInt();

            if (preference == 1){
                System.out.print("Insertion :");
                callSort.insertionSort(arr);
                for (int elem : arr){
                    System.out.print(elem + " ");
                }
            }else if (preference == 2){
                System.out.print("Selection :");
                callSort.selectionSort(arr);
            }else {
                System.out.print("Bubble :");
                callSort.bubbleSort(arr);
            }

            System.out.print("Do you want to continue? Type y or n: ");
            cont = sc.next().charAt(0);
        }


    }
}
