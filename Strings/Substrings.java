package Strings;
import java.util.Scanner;

public class Substrings {
    public static void subStrings(String str){
        int i = 0, n = str.length();
        while (i < n){
            int j = i+1;
            while (j <= n){
                System.out.println(str.substring(i , j));
                j++;
            }
            i++;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type something: ");
        String str = sc.nextLine();

        subStrings(str);

    }
}
