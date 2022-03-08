package Linked_List_01_DS;
import java.util.Scanner;

public class Find_a_Node_in_LL {

    public static Node<Integer> takeInputLL() { // Taking Input of Linked List -
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        Node<Integer> head = null;
        Node<Integer> tail = null;
        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);
            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
            }

            data = sc.nextInt();
        }
        return head;
    }

    public static int findNode(Node<Integer> head, int n){
        Node<Integer> currentNode = head;
        int count = 0;

        while (currentNode != null){
//            System.out.println(currentNode);
            if (currentNode.data == n){
                return count;
            }
            currentNode = currentNode.next;
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node<Integer> head = takeInputLL();
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        int result = findNode(head, n);
        System.out.println(result);
    }
}
