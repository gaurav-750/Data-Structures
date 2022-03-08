package Recursion_02;
import java.util.Scanner;

public class count_Number_Of_Zeroes {

    public static int countZeroesRec(int n){
        // base case
        if (n < 10){
            if (n == 0){
                return 1;
            }else {
                return 0;
            }
        }

        int smallOutput = countZeroesRec(n/10);
        System.out.println("n: " + n + ", " + "smallOutput : " + smallOutput);

        if (n % 10 == 0){
            return 1 + smallOutput;
        }else {
            return smallOutput;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int result = countZeroesRec(n);
        System.out.println(result);

//        System.out.println(0%10);
    }
}
