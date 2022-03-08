package Linked_List_Recursion_DS;
import java.util.Scanner;

public class Find_Node_Recursively {

    public static  Node<Integer> takeInputLL(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        Node<Integer> head = null;
        Node<Integer> tail = null;
        while (data != -1){
            Node<Integer> currentNode = new Node<>(data);
            if (head == null){
                head = currentNode;
                tail = currentNode;
            }else {
                tail.next = currentNode;
                tail = currentNode;
            }

            data = sc.nextInt();
        }

        return head;
    }

    public static int findNodeRecursively(Node<Integer> head, int x){
        // base case
        if (head == null){
            return -1;
        }
        if (head.data == x){
            return 0;
        }

        int output = findNodeRecursively(head.next, x);
//        System.out.println("output = " + output);
        if (output != -1){
            return output+1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node<Integer> head = takeInputLL();
        System.out.print("Enter x: ");
        int x = sc.nextInt();

        int result = findNodeRecursively(head, x);
        System.out.println("result = " + result);
    }
}
