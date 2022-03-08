package Strings;

import java.util.Scanner;

public class Reverse_each_Word {
    public static String reverseEachWord(String str){
//        int spaces = 0;
//        int i = 0;
//        // First find the index number of last space in the sentence :
//        while (i < str.length()){
//            if (str.charAt(i) == ' '){
//                spaces = i;
//            }
//            i++;
//        } // found


        String ans = "";
        int i = 0;

        while (i < str.length()){
            String str_f = "";
            int j = i;
            while (j < str.length() && str.charAt(j) != ' '){ // start of j loop
                if (str.charAt(j) != ' '){
                    str_f = str.charAt(j) + str_f;
                }

                j++;
                i++;
            } // End of j loop
            ans = ans + str_f + " ";
            i++;
        } // End of i loop

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type something: ");
        String str = sc.nextLine();

        String result =  reverseEachWord(str);
        System.out.println(result);

    }
}
