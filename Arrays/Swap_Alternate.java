package Arrays;
import java.util.Scanner;

public class Swap_Alternate {
    public static void swapAlternate(int[] arr){
        int i = 0;
        int j = 1;
        int temp;
        while (j < arr.length){
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i+=2;
            j+=2;
        }

        for (int k = 0; k < arr.length; k++){
            System.out.print(arr[k] + " ");
        }
        System.out.println();
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
            swapAlternate(arr);

        }



    }
}
