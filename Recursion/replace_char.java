package Recursion_02;
import java.util.Scanner;

public class replace_char {

    public static String replaceChar(String str, char orig, char r){
        // base case
        if (str.length() == 0){
            return str;
        }

        String output = replaceChar(str.substring(1), orig, r);
//        System.out.println(output);

        if (str.charAt(0) == orig){
            return r + output;
        }else {
            return str.charAt(0) + output;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
//        String s1 = "ab";
//        String s2 = "bc";
//        System.out.println(s1+s2);

        String str = sc.nextLine();
        char orig = sc.next().charAt(0);
        char r = sc.next().charAt(0);


        String result = replaceChar(str, orig, r);
        System.out.println(result);

    }
}
