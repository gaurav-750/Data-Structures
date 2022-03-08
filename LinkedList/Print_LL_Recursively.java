package Linked_List_Recursion_DS;
import java.util.Scanner;

public class Print_LL_Recursively {

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

    public static void printRecursively(Node<Integer> head){
        Node<Integer> temp = head;
//        System.out.println(temp);
        // base case
        if (temp == null){
            return;
        }
        // print the data elements -
        System.out.print(temp.data + " ");
        printRecursively(temp.next); // Call Recursion on next element

        return;
    }

    public static void printReverseRecursively(Node<Integer> head){
        Node<Integer> temp = head;
        System.out.println(temp);
        // base case
        if (temp == null){
            return;
        }
        printReverseRecursively(temp.next);
//        System.out.println(temp);
        System.out.print(temp.data + " ");

        return;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputLL();

        printRecursively(head);
//        System.out.print("Reverse Print: ");
        printReverseRecursively(head);
    }
}
