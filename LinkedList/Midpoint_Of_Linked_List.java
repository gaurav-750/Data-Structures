package Linked_List_Recursion_DS;
import java.util.Scanner;

public class Midpoint_Of_Linked_List {

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


    public static int lengthOfLL(Node<Integer> head){
        if (head == null){
            return 0;
        }
        if (head.next == null){
            return 1;
        }
        int smallAns = lengthOfLL(head.next);
        int Output = 1 + smallAns;
        return Output;
    }
            // 1st Method :-
    public static int findMidpointOfLL(Node<Integer> head){
        int length = lengthOfLL(head);
        int midpoint = 0;
        if (length % 2 == 0){
            midpoint = (length/2)-1;
        }else {
            midpoint = (length/2);
        }

        int count = 0;
        while (count != midpoint ){
            head = head.next;
            count++;
        }
        return head.data;
    }
                // 2nd Method - Using Recursion :-
    public static int findMPLL(Node<Integer> slow, Node<Integer> fast){
//        System.out.println("slow = " + slow);
//        System.out.println("fast = " + fast);
        if (slow == null){
            return -1;
        }
        if (fast.next == null || fast.next.next == null){
            return slow.data;
        }

        int smallAns = findMPLL(slow.next, fast.next.next);
//        System.out.println("fast = " + fast);
        return smallAns;
    }

    public static Node<Integer> midpointLL(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        if (slow == null){
            return slow;
        }
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputLL();

//        int result = findMidpointOfLL(head);
//        System.out.println("Main: " + result);

//        int result = findMPLL(head, head);
//        System.out.println("Main: " + result);

        Node<Integer> answer = midpointLL(head);
        System.out.println(answer);
        System.out.println(answer.data);
    }
}
