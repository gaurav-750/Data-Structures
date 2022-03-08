package Strings;
import java.util.Scanner;

public class Count_Words {
    public static int countWords(String str){
        if (str.length() > 0){
            int no_of_Spaces = 0;
            int i = 0;
            while (i < str.length()){
                if (str.charAt(i) == ' '){
                    no_of_Spaces++;
                }
                i++;
            }
            return no_of_Spaces+1;
        }
        else {
            return 0;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type something: ");
        String str = sc.nextLine();

        // Calling function :
        int words = countWords(str);
        System.out.println(words);

    }
}
