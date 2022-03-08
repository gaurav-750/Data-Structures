package Linked_List_Recursion_DS;

import java.util.Scanner;

public class Insert_Node_Recursively {

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

    public static Node<Integer> insertNodeRecursively(Node<Integer> head, int x, int pos){
//        System.out.println("head = " + head);
        if (head == null && pos > 0){ // for positions greater than length of LL
            return head;
        }

        if (pos == 0){ // If pos is 0, create a new Node and give appropriate references
            Node<Integer> newNode = new Node<>(x);
            newNode.next = head;
            return newNode;
        }else {
            Node<Integer> smallerHead = insertNodeRecursively(head.next, x, pos-1);
//            System.out.println("smallerHead = " + smallerHead);
//            System.out.println("head = " + head);
            head.next = smallerHead;
            return head;
        }

    }

//    public static void fun(Node<Integer> start){
//        if(start == null) {
//            return;
//        }
//        System.out.printf(String.valueOf(start.data + " "));
//
//        if(start.next != null ){
//            fun(start.next.next);
//            System.out.printf(String.valueOf(start.data + " "));
//            return;
//        }
//
//    }

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

//        System.out.println("Fun");
//        fun(head);

        System.out.print("Enter x: " );
        int x = sc.nextInt();
        System.out.print("Enter pos: ");
        int pos = sc.nextInt();

        Node<Integer> result = insertNodeRecursively(head, x, pos);
        printLLRecursively(result);


//        printLLRecursively(head);
    }
}
