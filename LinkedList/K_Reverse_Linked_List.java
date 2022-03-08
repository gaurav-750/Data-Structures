package Linked_List_Recursion_DS;
import java.util.Scanner;

public class K_Reverse_Linked_List {

    public static Node<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        Node<Integer> head = null;
        Node<Integer> tail = null;

        while (data != -1){
            Node<Integer> newNode = new Node<>(data);
            if (head == null){
                head = newNode;
                tail = newNode;
            }else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }

        return head;
    }

    public static Node<Integer> reverseLL(Node<Integer> head){
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> smallHead = reverseLL(head.next);
        Node<Integer> tail = head.next;
        tail.next = head;
        head.next = null;

        return smallHead;
    }

    public static int lengthLLRec(Node<Integer> head){
        // base case
        if (head == null){
            return 0;
        }

        int smallOutput = lengthLLRec(head.next);

        return smallOutput+1;
    }

    public static Node<Integer> k_ReverseLL(Node<Integer> head, int k){
        if (k == 0){
            return head;
        }
        int length = lengthLLRec(head);
//        System.out.println("length = " + length);
        if (length == 0){
            return head;
        }

        head =  reverseLL(head);
        if (k == length){
            return head;
        }

        Node<Integer> finalHead = null;
        Node<Integer> t1;
        Node<Integer> tail = null;

        int count = length;
        int biggerCount = 0;
        int x = (length/k);
        if (length % k == 0){
            x = x-1;
        }

        while (biggerCount <= x){ //number of times bigger loop gonna run
            t1 = head;
            int i = 0;
            while (i < (count-k)){
                t1 = t1.next;
                i++;
            }


            if (biggerCount == 0){
               finalHead = t1;
            }else {
                tail.next = t1;
            }

            int j = 0;
            while (j < k-1 && j < count-1){
                t1 = t1.next;
                j++;
            }
            tail = t1;

            count = count-k;
            if (count <= 0){
                tail.next = null;
            }
            biggerCount++;
        }

        return finalHead;
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
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = takeInput();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Node<Integer> result = k_ReverseLL(head, k);
        printLLRec(result);
    }
}
