package Linked_List_01_DS;
import java.util.Scanner;

public class Linked_List_Use {

    public static Node<Integer> createLinkedList(){
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        return n1;
    }

    public static void printLL(Node<Integer> head){
        System.out.println("Print " + head);

        Node<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
//        System.out.println(head.data);
//        System.out.println(head.next);
//        System.out.println(head.next.data);
//        System.out.println(head.next.next);
//        System.out.println(head.next.next.data);

    }

    public static void increment(Node<Integer> head){
        // Incrementing every value -

        while (head != null){
            head.data++; // here values are incrementing
            head = head.next; // head will now be pointing towards the next node
        }

    }

    // Taking a Linked list Input from user :-
    public static Node<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt(); // taking input for the first node element

        Node<Integer> head = null;
        Node<Integer> tail = null;
        while (data != -1){
            Node<Integer> currentNode = new Node<>(data);

            if (head == null){
                // Make this node as 'head' node and 'tail' node-
                head = currentNode;
                tail = currentNode;
                System.out.println(head);
            }else {
                // 1st Method :- Time Complexity - O(n^2)
//                Node<Integer> tail = head;
//                while (tail.next != null){
//                    tail = tail.next;
//                }

                // 2nd Method :- Time Complexity - O(n)
                tail.next = currentNode;
                tail = currentNode;
            }

            data = sc.nextInt();
        }

        return head;
    }

    public static void main(String[] args) {

//        Node<Integer> n1 = new Node<>(10);
//
//        System.out.println(n1.data);
//        System.out.println(n1.next);
////        n1.print();
//        System.out.println(n1);


        Node<Integer> head = takeInput(); //createLinkedList();
//        System.out.println("Main " + head);

//        increment(head);
        printLL(head);



//        System.out.println(head);
//        printLL(head);
//        System.out.println(head);
    }
}
