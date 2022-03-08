package Recursion_02;
import java.util.Scanner;

public class Geometric_Sum {

    public static double geoSum(int k){
        // base case
        if (k == 0){
            return 1;
        }

        double smallOutput = geoSum(k-1);

        double output = 1/Math.pow(2,k) + smallOutput;
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter k: ");
        int k = sc.nextInt();

//        System.out.println(1/ Math.pow(2,3));

        double result = geoSum(k);
        System.out.format("%.5f", result);
    }
}
