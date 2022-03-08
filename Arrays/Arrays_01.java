package Arrays;
import java.util.Scanner;


public class Arrays_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        int i = 0;
        while (i < n){
            System.out.print("Enter element at " + i + " index number: ");
            arr[i] = sc.nextInt();
            i++;
        }
        arr[n-1] = arr[0];
        System.out.println(arr[n-1]);
        arr[0] = arr[1];
        System.out.println(arr[0]);
        arr[1] = arr[n-1];
        System.out.println(arr[1]);
        System.out.println(arr[n-1]);
      /*  i = 0;
        while (i < n){
            System.out.print(arr[i] + " ");
            i++;
        } */

    }
}
