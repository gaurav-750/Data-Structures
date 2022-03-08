package Arrays;
import java.util.Scanner;

public class Arrange_numbers_in_Array {
    public static void arrange(int[] arr, int n){
        int i = 1;
        while (i <= n ){
            System.out.print(i + " ");
            i = i + 2;
        }
        if (n % 2 == 0){
            i = n;
        }
        else {
            i = n - 1;
        }
        while (i > 0) {
            System.out.print(i + " ");
            i = i - 2;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.print("Enter the number of test cases: ");
        int cases = sc.nextInt();

        int g = 0;
        while (g < cases){
           // System.out.print("Enter the size of array: ");
            int n = sc.nextInt();

            int[] arr = new int[n];
//            System.out.println(arr);

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            g++;
            arrange(arr , n);



        }

    }
}
