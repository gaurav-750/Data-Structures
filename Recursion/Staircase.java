package Recursion_02;
import java.util.Scanner;

public class Staircase {

    public static int stairCase(int n){
        // base case
        if (n == 0 || n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        int op_1 = stairCase(n-1);
        System.out.println("op1: " + op_1);

        int op_2 = stairCase(n-2);
        System.out.println("op2: " + op_2);

        int op_3 = stairCase(n-3);
        System.out.println("op3: " + op_3);

        int output = op_1 + op_2 + op_3;
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of staircases: ");
        int n = sc.nextInt();


        int result = stairCase(n);
        System.out.println("Main: " + result);
    }
}
