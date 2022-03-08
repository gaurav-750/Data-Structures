package Recursion_02;
import java.util.Scanner;

public class sum_of_digits {

    public static int sumOfDigits(int n){
        // base case
        if (n == 0){
            return 0;
        }

        int smallOutput = sumOfDigits(n/10);

        int output = (n % 10) + smallOutput;
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();


        int result = sumOfDigits(n);
        System.out.println(result);
    }
}
