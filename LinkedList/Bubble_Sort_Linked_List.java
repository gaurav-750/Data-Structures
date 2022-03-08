package Linked_List_Recursion_DS;
import java.util.Scanner;

public class Bubble_Sort_Linked_List {

    public static Node<Integer> takeInputLL(){
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

    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j){
        Node<Integer> finalHead = head;
        int count = 0;
        int temp_i = -1;
        int temp_j = -1;
        Node<Integer> t1 = head;

        while (head != null){
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
        while (head != null){
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

    public static int lengthLLRec(Node<Integer> head){
        // base case
        if (head == null){
            return 0;
        }

        int smallOutput = lengthLLRec(head.next);

        return smallOutput+1;
    }

    public static Node<Integer> bubbleSortLL(Node<Integer> head){
        if (head == null){
            return null;
        }

        Node<Integer> t1 = head;
        Node<Integer> t2 = head.next;
        Node<Integer> newHead = head;
        int i = 0, j = 1;
        int length = lengthLLRec(head);
//        System.out.println("length = " + length);

        int biggerLoop = 1;
        while (biggerLoop < length){

            while (t2 != null){
//                System.out.println(t1.data + " " + t2.data);
                if (t1.data >= t2.data){
//                    System.out.println(newHead.data);
                    newHead = swapNodes(head, i, j);
//                    System.out.println("newHead.data = " + newHead.data + " " + t1.data + " " + t2.data);
                }

                t1 = t1.next;
                t2 = t2.next;
                i++;
                j++;
            }

//            System.out.println("Outside");
            i = 0;
            j = 1;
            t1 = newHead;
            t2 = newHead.next;
            biggerLoop++;
        }

        return newHead;
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

        Node<Integer> finalHead = bubbleSortLL(head);
        printLLRec(finalHead);
    }
}
