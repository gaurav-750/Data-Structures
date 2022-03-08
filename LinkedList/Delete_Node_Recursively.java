package Linked_List_Recursion_DS;

import java.util.Scanner;

public class Delete_Node_Recursively {

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

    public static Node<Integer> deleteNodeRecursively(Node<Integer> head, int pos){

        if (head == null){
            return head;
        }

        if (pos == 0){
            Node<Integer> temp = head.next;
            return temp;
        }else {
            Node<Integer> smallerHead = deleteNodeRecursively(head.next, pos-1);
            head.next = smallerHead;
            return head;
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
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = takeInputLL();

        System.out.print("Enter pos: ");
        int pos = sc.nextInt();
        Node<Integer> result = deleteNodeRecursively(head, pos);
        printLLRecursively(result);
    }
}
