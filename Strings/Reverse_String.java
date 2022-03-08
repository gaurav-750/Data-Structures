package Strings;
import java.util.Scanner;

public class Reverse_String {
    public static String reverseString(String str){
//        String str_f = "";
//        int i = str.length()-1;
//        while (i >= 0){
//            str_f += str.charAt(i);
//            i--;
//        }
//
//        return str_f;

        String str_reversed = "";
        int n = str.length();
        str_reversed += str.charAt(0);
        int i = 1;
        while (i < str.length()){
            str_reversed = str.charAt(i) + str_reversed;
            i++;
        }

        return str_reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type something: ");
        String str = sc.nextLine();

        String reverse = reverseString(str);
        System.out.println(reverse);

    }
}
