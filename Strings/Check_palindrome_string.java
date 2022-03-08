package Strings;
import java.util.Scanner;

public class Check_palindrome_string {
    public static boolean checkPalindrome(String str){
        String str_reversed = "";
        int i = str.length()-1;
        while (i >= 0){
            str_reversed += str.charAt(i);
            i--;
        }
        System.out.println(str_reversed);

        return str.equals(str_reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a String here: ");
        String str = sc.nextLine();

        boolean palindrome = checkPalindrome(str);
        System.out.println(palindrome);

    }
}
