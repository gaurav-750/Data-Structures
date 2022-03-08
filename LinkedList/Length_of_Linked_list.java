package Linked_List_01_DS;
import java.util.Scanner;

public class Length_of_Linked_list {

    public static Node<Integer> createLL(){
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        Node<Integer> n5 = new Node<>(50);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        return n1;
    }

    public static int lengthLL(Node<Integer> head){
        int count = 0;

        while (head != null){
            count++;
            head = head.next;
        }

        return count;
    }

    public static void printithEle(Node<Integer> head, int i){
        int count = 0;
        while (head != null){
            if (count == i){
                System.out.print(head.data);
            }
            count++;
            head = head.next;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = createLL();

        // Length of Linked List -
        int result = lengthLL(head);
        System.out.println("Length of the Linked List: " + result);

        // Printing the ith element in the Linked List -
        System.out.print("Enter i: ");
        int i = sc.nextInt();

        printithEle(head, i);

    }
}
