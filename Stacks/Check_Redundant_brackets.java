package Stacks;
import java.util.Scanner;
import java.util.Stack;

public class Check_Redundant_brackets {

    public static boolean checkRedundancy(String str){
        Stack<Character> stack = new Stack<>();
        int i = 0;
        boolean isRedundant = false;


        while (i < str.length()){
            int temp = -1;
            while (str.charAt(i) != ')'){
                if(str.charAt(i)=='(') {
                    temp = i;
                }
                stack.push(str.charAt(i));
                i++;
                if(i>=str.length())
                    return false;
            }
            int count = i-temp;
            if(count<=1){
                return true;
            }

            if(i+1<str.length()) {
                str = str.substring(0, temp) + str.substring(i + 1);
            } else {
                return false;
            }
            System.out.println("str = " + str);
            i = 0;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string without spaces: ");
        String str = sc.nextLine();

        boolean result = checkRedundancy(str);
        System.out.println(result);
    }
}

//    public static boolean checkRedundantBrackets(String expression) {
//        //Your code goes here
//
//        Stack<Character> stack = new Stack<>();
//        int i = 0;
//        boolean isRedundant = false;
//
//        while (i < expression.length()){
//            while (expression.charAt(i) != ')'){
//                stack.push(expression.charAt(i));
//                i++;
//            }
//            int count = 0; int j = i-1;
//            while (j >= 0 && expression.charAt(j) != '('){
//                stack.pop();
//                count++;
//                j--;
//            }
//            stack.pop();
//            if (count <= 1){
//                return true;
//            }
//
//            expression = expression.substring(0,j) + expression.substring(i+1);
//            // System.out.println("str = " + expression);
//            i = j;
//        }
//
//        return false;
//    }