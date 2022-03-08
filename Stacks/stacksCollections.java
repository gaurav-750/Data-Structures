package Stacks;
import java.util.Scanner;
import java.util.Stack; // import this for using INBUILT STACK CLASS

public class stacksCollections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>(); // Stack 'inbuilt' Class In JAVA
/*
        stack.push(10);
        System.out.println(stack.size());
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.size());
        System.out.println(stack.peek()); // prints the topmost element
        System.out.println(stack.isEmpty());

*/
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int k:
             arr) {
            stack.push(k); // inserting element in stack
        }

        while (! stack.isEmpty()){
            System.out.print(stack.pop() + " "); // deleting and printing elements from stack
        }

//        System.out.println(stack.size());
    }
}
