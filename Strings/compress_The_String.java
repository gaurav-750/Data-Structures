package Strings;
import java.util.Scanner;

public class compress_The_String {
    public static String compressString(String str){
        int i = 0 , j = 1;
        String str_f = "";
        while (j < str.length()){
            int counter = 1;
            while (j < str.length() && str.charAt(i) == str.charAt(j)){ // start of loop
                counter++;
                i++;
                j++;
            } // end of loop
            if (counter > 1){
                str_f = str_f + str.charAt(i) + counter;
            }
            else {
                str_f = str_f + str.charAt(i) ;
            }
            i++;
            j++;
        }
        if (str.charAt(str.length()-1) != str.charAt(str.length() - 2)){
            str_f = str_f + str.charAt(str.length() - 1);
        }


       return str_f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.next();

        String result = compressString(str);
        System.out.println(result);

    }
}
