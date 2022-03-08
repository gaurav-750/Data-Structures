package Linked_List_01_DS;

import java.util.Scanner;

public class Change_Nodes {

    public static Node<Integer> takeInputLL(){
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

    public static Node<Integer> changeNodes(Node<Integer> head, int i, int j){
        int length = lengthLL(head);
        Node<Integer> finalHead = head;
        int count = 0;
        int temp_i = -1;
        int temp_j = -1;
        Node<Integer> t1 = head;

        while (count <= j){
            if (count == i){
                temp_i = head.data;
            }
            if (count == j){
                temp_j = head.data;
            }
            head = head.next;
            count++;
        }

        count = 0;
        head = finalHead;
        while (count <= j){
            if (count == i){
                head.data = temp_j;
            }
            if (count == j){
                head.data = temp_i;
            }
            head = head.next;
            count++;
        }

        return finalHead;
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

        System.out.print("Enter i: ");
        int i = sc.nextInt();
        System.out.print("Enter j: ");
        int j = sc.nextInt();

        Node<Integer> result = changeNodes(head, i, j);
        printLLRecursively(result);
    }
}
