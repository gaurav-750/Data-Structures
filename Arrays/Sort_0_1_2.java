package Arrays;
import java.util.Scanner;

public class Sort_0_1_2 {
    public static void sortZ_O_T(int[] arr){
        int i = 0;
        int n = arr.length;
        int counter_0 = 0;
        int counter_1 = 0;
        int counter_2 = 0;

        while (i < n){
            if (arr[i] == 0){
                counter_0++;
            }
            else if (arr[i] == 1){
                counter_1++;
            }
            else {
                counter_2++;
            }
            i++;
        }

        int j = 0;
        while (j < n){
           if (j < counter_0){
              arr[j] = 0;
           }
           else if (j >= counter_0 && j < (counter_0+counter_1)){
               arr[j] = 1;
           }
           else {
               arr[j] = 2;
           }
           j++;
        }

        // Printing :
        for (int k = 0; k < n; k++){
            System.out.print(arr[k] + " ");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases to be run: ");
        int cases = sc.nextInt();
        int g = 0;
        while (g < cases){
            System.out.print("Enter the size of array: ");
            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            g++;
            sortZ_O_T(arr);

        }


    }
}
