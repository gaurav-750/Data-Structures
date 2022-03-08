package Recursion_02;
import java.util.Scanner;

public class remove_X {

    public static String removeX(String str){
        System.out.println(str);
        // base case
        if (str.length() == 0){
            return str;
        }

        String str_op = removeX(str.substring(1));
        System.out.println(str_op);

        if (str.charAt(0) == 'x'){
            return str_op;
        }else {
            return str.charAt(0) + str_op;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");

        String str = sc.nextLine();

        String result = removeX(str);
        System.out.println(result);
    }
}
