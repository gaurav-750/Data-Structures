package Strings;
import java.util.Scanner;

public class Reverse_string_word_wise {
    public static String reverseStringWord_wise(String input){
        // Looking for index number for last space
        int a = 0;
        int spaces = 0;
        while (a < input.length()){
            if (input.charAt(a) == ' '){
                spaces = a;
            }
            a++;
        }
        // if there is a single word as input , we would only give that word as output
        if (spaces == 0){
            return input;
        }

        String ans = "";
        int i = 0;
        int eachEnd =0;
        while (i < spaces){

            for (int j = i; j < input.length(); j++){
                if (input.charAt(j) == ' '){
                    eachEnd = j;
                    break;
                }
            }

            String str_f = ""; // Creating a new string
            while (i < eachEnd){
                str_f = str_f + input.charAt(i);
                i++;
            }
            i++;
            ans = str_f +" " + ans;
        }
        // new while Loop :- For last word of the input
        int i2 = spaces+1;
        String str_f = "";
        while (i2 < input.length()){
            str_f = str_f + input.charAt(i2);
            i2++;
        }
        ans = str_f +" " + ans;
        // returning the final ans :
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type something: ");
        String input = sc.nextLine();

        String result = reverseStringWord_wise(input);
        System.out.println(result);
        // 30-07-2021 last seen


    }
}