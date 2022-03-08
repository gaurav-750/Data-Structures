package Recursion_02;
import java.util.Scanner;

public class multiply_Two_Integers {

    public static int multiply2Integers(int m, int n){
        // base case
        if (n == 0){
            return 0;
        }

        int smallOutput = multiply2Integers(m, n-1);

        int output = m + smallOutput;
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m: ");
        int m = sc.nextInt();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int result = multiply2Integers(m, n);
        System.out.println("Main: " + result);

        int num = sc.nextInt();
        System.out.print(num/10);


    }
}
