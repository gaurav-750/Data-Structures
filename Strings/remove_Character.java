package Strings;

import java.util.Scanner;

public class remove_Character {
    public static String removeChar(String str , char X){
        int i = 0;
        String str_f = "";
        while (i < str.length()){
            if (str.charAt(i) != X) {
                str_f = str_f + str.charAt(i);
            }
            i++;
        }
        return str_f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.next();

        System.out.print("Enter X: ");
        char X = sc.next().charAt(0);

        String result = removeChar(str , X);
        System.out.println(result);

    }
}
