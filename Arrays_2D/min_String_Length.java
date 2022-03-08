package Arrays_2D;
import java.util.Scanner;

public class min_String_Length {
    public static String minLengthWord(String input){
        int min = Integer.MAX_VALUE;
//        System.out.println(input.length());
        String minimum = "";
        int i = 0;
        int word_counter;
        while (i < input.length()){ // start of big loop

            word_counter = 0;
            String min_Ans = "";
            while (i < input.length() && input.charAt(i) != ' '){
                min_Ans = min_Ans + input.charAt(i);

                word_counter++;
                i++;
            }

            if (i == input.length()){
                i--;
            }

            if (i < input.length()){
                if (min > word_counter){
                    min = word_counter;
                    minimum = min_Ans;
                }
                i++;
            }



        } // end of big loop

        return minimum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String answer = minLengthWord(str);
        System.out.println(answer);
    }
}
