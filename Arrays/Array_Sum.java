package Arrays;
import java.util.Scanner;

public class Array_Sum {
    public static int Sum(int arr[]){
        int i = 0;
        int arraySum = 0;
        while (i < arr.length){
            arraySum = arraySum + arr[i];
            i++;
        }
        return arraySum;
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
            g++;
            int result = Sum(arr);
            System.out.println(result);

        }


    }
}
