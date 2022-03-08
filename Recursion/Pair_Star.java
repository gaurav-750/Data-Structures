package Recursion_02;
import java.util.Scanner;

public class Pair_Star {

    public static String addStars(String str){
        // base case
        if (str.length() == 1){
            return str;
        }

        String smallOutput = addStars(str.substring(1));
        System.out.println(smallOutput);

        if (str.charAt(0) == str.charAt(1)){
            return str.charAt(0) + "*" + smallOutput;
        }else {
            return str.charAt(0) + smallOutput;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        String result = addStars(str);
        System.out.println("Main: " + result);

    }
}
