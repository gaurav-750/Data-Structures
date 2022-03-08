package Recursion_02;
import java.util.Scanner;

public class replace_pi {

    public static String replacePi(String str){
        // base case
        if (str.length() <= 1){
            return str;
        }

        if (str.charAt(0) == 'p' && str.charAt(1) == 'i'){
            // Call recursion on String of length n-2

            String str_op = replacePi(str.substring(2));
//            System.out.println(str_op + ", str: " + str);
            return 3.14 + str_op;
        }else {
            // Call recursion on String of length n-1

            String str_op = replacePi(str.substring(1));
//            System.out.println(str_op + ", str: " + str);
            return str.charAt(0) + str_op;
        }




    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");

        String str = sc.nextLine();

        String result = replacePi(str);
        System.out.println(result);
    }
}
