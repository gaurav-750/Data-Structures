package Linked_List_Recursion_DS;

import java.util.Scanner;

public class Reverse_LL_recursively {

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

    public static Node<Integer> reverseLLRecursively(Node<Integer> head){
//        System.out.println("head = " + head);
        if (head == null || head.next == null){
            return head;
        }else {
            Node<Integer> smallHead = reverseLLRecursively(head.next);
//            System.out.println("smallHead = " + smallHead);
//            System.out.println("head 1 = " + head);
            Node<Integer> tail = smallHead;
//            System.out.println("tail 1 = " + tail);
            while (tail.next != null){
                tail = tail.next;
            }
            tail.next = head;
            head.next = null;

//            System.out.println("tail 2 = " + tail);
//            System.out.println("head 2 = " + head);
            return smallHead;
        }

    }

    public static Node<Integer> reverseLLRecursivelyBest(Node<Integer> head){
        // base case
        if (head == null || head.next == null){
            return head;
        }

        Node<Integer> smallHead = reverseLLRecursivelyBest(head.next);

        Node<Integer> tail = head.next;
        tail.next = head;
        head.next = null;
        return smallHead;
    }

    public static void printLLRecursively(Node<Integer> head){
        if (head == null){
            return;
        }
        System.out.print(head.data + " ");
        printLLRecursively(head.next);

        return;
    }

    public static Node<Integer> midPointLLRec(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        if (slow ==null) {
            return null;
        }

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        Node<Integer> head = takeInputLL();

        Node<Integer> ans = midPointLLRec(head);
        if (ans != null)
            System.out.println("Midpoint: " + ans.data);

        Node<Integer> result = reverseLLRecursively(head);
        printLLRecursively(result);
    }
}
