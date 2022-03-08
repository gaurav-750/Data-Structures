package Linked_List_Recursion_DS;
import java.util.Scanner;

public class Merge_Sort_LL {

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

    public static Node<Integer> mergeLL(Node<Integer> head1, Node<Integer> head2){
        if (head1 == null){
            return head2;
        }else if (head2 == null){
            return head1;
        }

        Node<Integer> t1 = head1, t2 = head2;
        Node<Integer> finalHead = t1;
        Node<Integer> tail;
        if (t1.data > t2.data){
            finalHead = t2;
            tail = t2;
            t2 = t2.next;
        }else {
            tail = t1;
            t1 = t1.next;
        }

        while (t1 != null && t2 != null){
//            System.out.println("Inside while");
            if (t1.data < t2.data){
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            }else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }
        // One list is OVER!
        if (t2 == null){ // if L2 is over, append t1
            tail.next = t1;
        }else {
            tail.next = t2;
        }

        return finalHead;
    }

    public static Node<Integer> mergeSortLL(Node<Integer> head){
        // base case
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }

        Node<Integer> mid = midpointLL(head);
//        System.out.println(mid.data);
        Node<Integer> head1 = head;
        while (head1 != mid){
            head1 = head1.next;
        }
        Node<Integer> head2 = head1.next;
        head1.next= null;
        head1 = head;

        Node<Integer> head1_ans = mergeSortLL(head1);
        Node<Integer> head2_ans = mergeSortLL(head2);

//        System.out.println(head1_ans.data + " " + head2_ans.data);
        Node<Integer> finalHead = mergeLL(head1_ans, head2_ans);
//        System.out.println("After merging: ");
//        printLLRecursively(finalHead);
//        System.out.println("finalHead = " + finalHead.data);
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
        Node<Integer> result = mergeSortLL(head);

        printLLRecursively(result);
    }
}
