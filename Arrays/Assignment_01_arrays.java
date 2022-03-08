package Arrays;
import java.util.Scanner;

public class Assignment_01_arrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int cases = sc.nextInt();
        int g = 1;

        while (g <= cases){
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            int i = 0;
            while (i < n){
                arr[i] = sc.nextInt();
                i++;
            }
            i = 0;
            int sum = 0;
            while (i < n){
                sum = sum + arr[i];
                i++;
            }
            System.out.println(sum);
            g++;
        }
       System.out.println("thanks!");

    }
}
