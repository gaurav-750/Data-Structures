package Stacks;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Reverse_Stack {

    public static void reverseStack(Stack<Integer> stack){
        int n = stack.size();
        ArrayList<Integer> arrL = new ArrayList<>(n);

        for (int j = 0; j < n; j++) {
            arrL.add(stack.pop());
        }

        int k = 0;
        while (k < n){
            stack.push(arrL.get(k));
            k++;
        }

        System.out.println("After Reversing!");
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of stack: ");
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int k:
             arr) {
            stack.push(k);
        } // inserting elements in 'stack'

        reverseStack(stack);
    }
}
