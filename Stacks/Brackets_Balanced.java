package Stacks;
import java.util.Scanner;
import java.util.Stack;

public class Brackets_Balanced {

    public static boolean balancedBrackets(String str){
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while (i < str.length()){
            if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '['){
                stack.push(str.charAt(i));
            }else if (str.charAt(i) == '}' || str.charAt(i) == ')' || str.charAt(i) == ']'){
                if (stack.isEmpty()){
                    return false;
                }
                char ch = stack.peek();

                if (ch == '{' && str.charAt(i) == '}'){
                    stack.pop();
                }else if (ch == '(' && str.charAt(i) == ')'){
                    stack.pop();
                }else if (ch == '[' && str.charAt(i) == ']'){
                    stack.pop();
                }else {
                    return false;
                }
            }
            
            i++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of brackets: ");
        String str = sc.nextLine();

        System.out.println(balancedBrackets(str));
    }
}
