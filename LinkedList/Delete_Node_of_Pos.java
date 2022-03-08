package Linked_List_01_DS;
import java.util.Scanner;

public class Delete_Node_of_Pos {

    public static Node<Integer> takeInputLL(){ // Taking Input of Linked List -
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

    public static int lengthLL(Node<Integer> head){
        int count = 0;

        while (head != null){
            count++;
            head = head.next;
        }

        return count;
    }

    public static Node<Integer> deleteNode(Node<Integer> head, int pos){
        int length = lengthLL(head);

        Node<Integer> previousNode = head;
        int count = 0;

        if (pos == 0){ // If pos is 0, return the Node at 1 as Head
            head = head.next;
            return head;
        }else if (pos >= length) {
            return head;
        }

        while (count < pos-1 && previousNode.next.next != null){
            previousNode = previousNode.next;
            count++;
        }

        if (pos == length-1){
            previousNode.next = null;
        }else {
            previousNode.next = previousNode.next.next;
        }

        return head;
    }

    public static void printLL(Node<Integer> head){
        Node<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node<Integer> head = takeInputLL();
        System.out.print("Enter pos: ");
        int pos = sc.nextInt();

        Node<Integer> resultNode = deleteNode(head, pos);
        printLL(resultNode);

    }
}
