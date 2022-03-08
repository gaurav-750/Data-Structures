package Linked_List_Recursion_DS;

import java.util.Scanner;

public class Delete_Alternate_Nodes {

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

    public static void deleteAlternateNodes(Node<Integer> head){
        if (head == null){
            return;
        }
        Node<Integer> t1 = head.next;

        while (t1 != null){
            head.next = t1.next;
            head = head.next;

            if (head != null){
                t1 = head.next;
            }else {
                return;
            }
        }

    }

    public static void printLLRecursively(Node<Integer> head){
        if (head == null){
            return;
        }
        System.out.print(head.data + " ");
        printLLRecursively(head.next);
        return;
    }

    public static void main(String[] args) {

        Node<Integer> head = takeInputLL();

        deleteAlternateNodes(head);
        printLLRecursively(head);
    }
}
