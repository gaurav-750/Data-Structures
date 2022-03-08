package Stacks;
import java.util.Scanner;

public class stackUse {
    public static void main(String[] args) throws stackFullException, stackEmptyException {
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the size of stack: ");
//        int sizeOfStack = sc.nextInt();

//        stacksUsingArrays stack = new stacksUsingArrays(); // creating an object named 'stack'

        stacksUsingLL<Integer> stack = new stacksUsingLL<>();
/*
        stack.push(10); // for inserting an element
        stack.top(); // to read an element on top of the stack
        stack.pop(); // to remove topmost element and returns it
        System.out.println(stack.size()); // to check the size of stack
        stack.isEmpty(); // to check whether stack is empty or not
*/

        int[] arr = {1,3,5,7,9,11};

/*
        int[] arr = new int[sizeOfStack];
        for (int i = 0; i < sizeOfStack; i++){
            arr[i] = sc.nextInt();
        }
*/

        for (int k: arr){
            stack.push(k);
        }

        System.out.println(stack.size());

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
//
//        System.out.println(stack.isEmpty());


    }
}
