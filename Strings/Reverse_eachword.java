package Strings;
import java.util.Scanner;

public class Reverse_eachword {
    public static String Reverse_word(String str){
        String ans = "";
        int eachStart = 0;
        int i = 0;
        int j = 0;
        while (i < str.length()){
            if (str.charAt(i) == ' '){
                j = i - 1;
                i = i+1;
            }
            String reverse_word = "";
            while (i <= j){
                reverse_word = str.charAt(i) + reverse_word;
                i++;
            }
           ans = reverse_word + " ";
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type something: ");
        String str = sc.nextLine();


        Reverse_word(str);



    }
}
