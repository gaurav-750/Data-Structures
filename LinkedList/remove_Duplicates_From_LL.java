package Linked_List_01_DS;
import java.util.Scanner;

public class remove_Duplicates_From_LL {

    public static Node<Integer> takeInputLL(){
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

    public static Node<Integer> removeDupFromLL(Node<Integer> head){
        if (head == null){
            return head;
        }else if (head.next == null){
            return head;
        }
        Node<Integer> currentNode = head;
        Node<Integer> nextNode = head.next;

        while(nextNode.next != null) {
            if (currentNode.data == nextNode.data) {
                nextNode = check(nextNode);
                currentNode.next = nextNode;
            }
            currentNode = currentNode.next;
            if (nextNode.next != null) {
                nextNode = nextNode.next;
            }
        }

        if (currentNode.data == nextNode.data){
            currentNode.next = null;
        }else {
            currentNode.next = nextNode;
        }
//
////
//
        return head;
    }

    public static Node<Integer> check(Node<Integer> head){
        Node<Integer> currentNode = head;
        if(currentNode.data == currentNode.next.data){
            currentNode = currentNode.next;
        }
        return currentNode.next;
    }

    public static void printLL(Node<Integer> head){
        Node<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputLL();

        Node<Integer> result = removeDupFromLL(head);
        printLL(result);
    }
}
