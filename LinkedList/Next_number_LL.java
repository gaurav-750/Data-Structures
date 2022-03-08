package Linked_List_Recursion_DS;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Next_number_LL {

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

    public static Node<Integer> reverseLL(Node<Integer> head){
        // base case
        if (head == null || head.next == null){
            return head;
        }

        Node<Integer> smallHead = reverseLL(head.next);

        Node<Integer> tail = head.next;
        tail.next = head;
        head.next = null;
        return smallHead;
    }

    public static Node<Integer> nextNumberTry(Node<Integer> head){
        Node<Integer> tempHead = head;
        Node<Integer> t1;
        Node<Integer> finalHead = head;

        while (head.next != null){
            head = head.next;
        }

        if (head.data != 9){
            head.data = head.data+1;
        }else {
            Node<Integer> reverseHead = reverseLL(tempHead);
            t1 = reverseHead;
            while (t1 != null && t1.data == 9){
                t1.data = 0;
                t1 = t1.next;
            }
            if (t1 == null){
                Node<Integer> zeroHead = new Node<>(1);
                zeroHead.next = reverseHead;
                return zeroHead;
            }else {
                t1.data++;
            }

            finalHead = reverseLL(reverseHead);
        }

        return finalHead;
    }

    public static Node<Integer> nextNumberLL(Node<Integer> head){
        if (head == null){
            return null;
        }

        String str = "";
        while (head!=null){
            str = str + (head.data);
            head = head.next;
        } // converting given linked list into a String (given Linked list's data)
        System.out.println(str);
        long ll_int = Long.parseLong(str); // converting string into integer
        ll_int = ll_int+1;

        String strUpdated = Long.toString(ll_int); // converting updated ll_int to String

        long n = ll_int;
        Stack<Integer> stack = new Stack<>();
        while (n != 0){
            stack.push((int) (n%10));
            n = n/10;
        }

        Node<Integer> finalHead = null;
        Node<Integer> tail = null;
        int i = 0;

        while (i < strUpdated.length()){
            Node<Integer> currentNode = new Node<>(stack.pop());

            if (finalHead == null){
                finalHead = currentNode;
            }else {
                tail.next = currentNode;
            }

            tail = currentNode;
            i++;
        }

        return head;
    }

    public static void printLLRec(Node<Integer> head){
        // base case
        if (head == null){
            return;
        }

        System.out.print(head.data + " ");
        printLLRec(head.next);
    }

    public static void main(String[] args) {

        Node<Integer> head = takeInputLL();
//        Node<Integer> finalHead = nextNumberLL(head);
        Node<Integer> resultHead = nextNumberTry(head);

        printLLRec(resultHead);
    }
}
