package Arrays;
import java.util.Scanner;

public class change_Alternate {
    public static void swapAlternate(int arr[]) {
        int i = 0;
        // System.out.println(arr.length);
        while (i < arr.length-2) {
            arr[arr.length - 1] = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = arr[arr.length - 1];
            arr[arr.length - 1] = 0;

            System.out.print(arr[i] + " " + arr[i+1] + " ");
            i = i + 2;
        }

        if ((arr.length-1) % 2 != 0){
            System.out.print(arr[arr.length-2]);
        }

    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.print("Enter the number of test cases: ");
        int cases = sc.nextInt();

        int g = 0;
        while (g < cases){
           // System.out.print("Enter the size of array: ");
            int n = sc.nextInt();
            int arr[] = new int[n+1];


            for (int i = 0; i < n; i++){
             //   System.out.print("Enter element at " + i + " th position: ");
                arr[i] = sc.nextInt();
            }
            //System.out.println(arr[arr.length-1]);
            g++;
            swapAlternate(arr);

        }



    }
}
