package Recursion_02;
import java.util.Scanner;

public class String_to_Integer {

    public static int strToInt(String str){
        // base case
        if (str.length() == 0){
            return 0;
        }

        int smallOutput = strToInt(str.substring(1));
        int ten_power = (int) Math.pow(10, str.length()-1);

        int output = Integer.parseInt(String.valueOf(str.charAt(0))) * ten_power + smallOutput;
//        System.out.println(smallOutput + ", " + str + ", " + ten_power +", " + output);

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numeric String: ");
        String str = sc.nextLine();

        String s = "0111";
//        System.out.println(str.charAt(0));
        System.out.println(Integer.parseInt(s));


        int result = strToInt(str);
        System.out.println(result);
//        result.getClass().getSimpleName();

    }
}
