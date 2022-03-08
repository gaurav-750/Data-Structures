package Linked_List_Recursion_DS;

import java.util.Scanner;

public class Even_After_Odd_LL {

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

    public static Node<Integer> evenAfterOdd(Node<Integer> head){

        // If the size is 0 or 1 - Just return head
        if (head == null || head.next == null){
            return head;
        }

        // If the size of LL is 2 :-
        if (head.next.next == null){ // size of LL is 2
            if (head.data%2 != 0){ // and first number is odd
                return head;
            }else { // and first number is even
                Node<Integer> secondHead = head.next;
                if (secondHead.data%2 != 0){ // if second number is odd
                    secondHead.next = head;
                    head.next = null;
                    return secondHead;
                }else { // second number is even
                    return head;
                }
            }
        }


        Node<Integer> finalHead = head;
        Node<Integer> oddTail = null; // chain for odd numbers

        // checking whether 1st number is even :-
        Node<Integer> temp_final = null;
        Node<Integer> temp = head; // chain for even numbers

        if (head.data%2 == 0){ // first number is EVEN
            temp_final = head;
            temp = temp_final;
            head = head.next;

            while ((head != null && head.data%2 == 0)){ // finding the first odd number
                temp.next = head;
                temp = temp.next;
                head = head.next;
            }
            if (head == null){
                return temp_final;
            }
// we got the first odd number - Now, we assign oddTail and finalHead to it
            finalHead = head;
            oddTail = head;
            head = head.next;
        }else { // first number is ODD
            oddTail = head;
//            finalHead = head;
            head = head.next;

            while ((head != null && head.data%2 != 0)){ // finding the first even number
                oddTail.next = head;
                oddTail = oddTail.next;
                head = head.next;
            }
            if (head == null){
                return finalHead;
            }
// we got first even number - Now, we assign temp_final and temp to it
            temp_final = head;
            temp = temp_final;
            head = head.next;
        }

        while (head != null && head.next != null){
            if ((head.data%2) != 0){
                // number is odd
                oddTail.next = head;
                oddTail = oddTail.next;
                head = head.next;
            }else {
                // number is even
                temp.next = head;
                temp = temp.next;
                head = head.next;
            }
        }

        // For the Last Number -
        if ((head.data%2) != 0){ // number is odd
            oddTail.next = head;
            oddTail = oddTail.next;
            oddTail.next = temp_final;
            temp.next = null;
        }else { // number is even
            temp.next = head;
            temp = temp.next;
            temp.next = null;
            oddTail.next = temp_final;
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
        Node<Integer> head = takeInputLL();

        Node<Integer> result = evenAfterOdd(head);
        printLLRecursively(result);
    }
}
