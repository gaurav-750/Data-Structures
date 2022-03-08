package Recursion_02;
import java.util.Scanner;

public class check_Palindrome_Recursion {

    public static boolean isStringPalindrome(String str){
        // base case
//        System.out.println(str);
        if (str.length() <= 1){
            return true;
        }

        boolean output = isStringPalindrome(str.substring(1, str.length() - 1)); // call recursion on string from 2nd char to last second char
        System.out.println("output: " + output + ", " + "str: " + str);

        if (output == true){
            return str.charAt(0) == str.charAt(str.length() - 1);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();


        boolean result = isStringPalindrome(str);
        System.out.println("Main: " + result);

//        String s = "Gaurav somani";
//        System.out.println(s.substring(1, s.length() - 1));
    }
}
