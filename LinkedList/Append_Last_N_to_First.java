package Linked_List_01_DS;
import java.util.Scanner;

public class Append_Last_N_to_First {

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

    public static int lengthLL(Node<Integer> head){
        int count = 0;

        while (head != null){
            count++;
            head = head.next;
        }

        return count;
    }

    public static Node<Integer> appendLastNtoFirst(Node<Integer> head, int N){
        int length = lengthLL(head);
        Node<Integer> currentNode = head;
//        System.out.println("head = " + head);

        int count = 0;
        while (count < length){
//            System.out.println("currentNode 1st While: " + currentNode);
            if (count == length-1){
                currentNode.next = head;
//                System.out.println("curr = " + currentNode.next);
                break;
            }
            currentNode = currentNode.next;
            count++;
        }

        count = 0;
        currentNode = head;
//        System.out.println("CurrentNode outside 1st While: " + currentNode);
        Node<Integer> address = head;

        while (count < length){
//            System.out.println("currentNode 2nd While= " + currentNode);
            if (count == length-N-1){
                address = currentNode.next;
                currentNode.next = null;
                break;
            }
            currentNode = currentNode.next;
            count++;
        }

        return address;
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

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        Node<Integer> result =  appendLastNtoFirst(head, N);
        printLL(result);
    }
}
