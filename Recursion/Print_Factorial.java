package Recursion_02;
import java.util.Scanner;

public class Print_Factorial {

    public static void printFactorial(int n, int outputSoFar){
        // base case
        if (n == 0){
            System.out.println(outputSoFar);
            return;
        }

        outputSoFar = outputSoFar*n;
        printFactorial(n-1, outputSoFar);

        return;
    }

    // Date: 01-12-2021
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        printFactorial(n, 1);
    }
}
/*
    In case of printing, you will most probably need to send something like outputSoFar.
 */