package Strings;

import java.util.Scanner;

public class remove_Consecutive_Duplicates {
    public static String removeDuplicates(String str) {
        int i = 0;
        String str_f = str.charAt(0) + "";
        int j = 1;
        while (j < str.length()){ // start of j loop
            if (str.charAt(j) == str.charAt(i)){
                j++;
                i++;
            }
            else {
                str_f = str_f + str.charAt(j);
                j++;
                i++;
            }

        } // end of j loop


        return str_f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.next();

        String result = removeDuplicates(str);
        System.out.println(result);

    }
}
