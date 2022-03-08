package Linked_List_01_DS;

import java.net.Inet4Address;
import java.util.Scanner;

public class Reverse_Linked_List {

    public static Node<Integer> takeInputLL(){ // Taking Input of Linked List -
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

    public static int lengthLL(Node<Integer> head){
        int count = 0;

        while (head != null){
            count++;
            head = head.next;
        }

        return count;
    }

    public static void reverseLL(Node<Integer> head) {
        int length = lengthLL(head);

        int i = 0;
        int initial_length = length;
        while (i < initial_length){
            Node<Integer> currentNode = head;
            int count = 0;
            while (count < length){
                if (count == (length-1)){
                    System.out.print(currentNode.data + " ");
                }

                currentNode = currentNode.next;
                count++;
            }
            length--;
            i++;
        }

    }

    //  ---------     Through Recursion :-      --------
    public static void reverseLLRecursively(Node<Integer> head){
        // base case
        if (head == null){
            return;
        }

        reverseLLRecursively(head.next);

        System.out.print(head.data + " ");
        return;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputLL();

//        reverseLL(head);
        reverseLLRecursively(head);
    }
}
