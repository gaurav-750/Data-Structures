package Stacks;
import java.util.Scanner;
import java.util.Stack; // importing class 'Stack' from java collections

public class Bracket_Parentheses {

    public static String removeChar(String str, int i, int j){
        System.out.println("j = " + j);
        return str.substring(i+1,j) + str.substring(j+1);
    }

    public static boolean isBalanced(String str){
        int i = 0, j = i+1;
        boolean isBalanced = false;
        int length_str = str.length();

        while (i <= length_str && j <= length_str){
            System.out.println("Top-while: " + length_str);

            if(str.charAt(i) == '}' || str.charAt(i) == ')'){
                return false;
            }

            if (str.charAt(i) == '{'){
                while (j < length_str && str.charAt(j) != '}'){
                    j++;
                }
                if (j == length_str){
                    return false;
                }else {
                    isBalanced = true;
                    str = removeChar(str, i, j);
                    System.out.println("str = " + str);
                }
            }else if (str.charAt(i) == '('){
                System.out.println("In else-if: " + j);
                while (j < length_str && str.charAt(j) != ')'){
                    j++;
                }
                if (j == length_str){
                    return false;
                }else {
                    isBalanced = true;
                    str = removeChar(str, i, j);
                    System.out.println("str = " + str);
                }
            }

            i = 0;
            j = i+1;
            length_str = length_str-2;
        }

        if (isBalanced == true){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>(); // creating an object named 'stack'

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        boolean result = isBalanced(str);
        System.out.println(result);
    }
}
