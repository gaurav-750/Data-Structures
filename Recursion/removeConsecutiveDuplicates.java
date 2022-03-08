package Recursion_02;
import java.util.Scanner;

public class removeConsecutiveDuplicates {

    public static String removeDup(String str){
        // base case
        if (str.length() == 1){
            return str;
        }

        String smallStr = removeDup(str.substring(1));
//        System.out.println(smallStr);

        if (str.charAt(0) == str.charAt(1)){
            // if there are duplicate characters, just return smallStr :
            return smallStr;
        } else {
            return str.charAt(0) + smallStr;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");

        String str = sc.nextLine();

        String result = removeDup(str);
        System.out.println("Main: " + result);

    }
}
