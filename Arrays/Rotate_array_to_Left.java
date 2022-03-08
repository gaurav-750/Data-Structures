package Arrays;
import java.util.Scanner;

public class Rotate_array_to_Left {
    public static void rotate(int arr[] , int D){
        int n = arr.length;
        int i = D;
        int temp;
        int j = 0;
        while (j < n){
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            if (i == n){
                i = n-D;
            }
            j++;
        }
        for (int k = 0; k < n; k++){
            System.out.print(arr[k] + " ");
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int cases = sc.nextInt();

        int g = 0;
        while (g < cases){
            System.out.print("Enter the size of array: ");
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter D: ");
            int D = sc.nextInt();
            g++;
            rotate(arr , D);



        }

    }
}
