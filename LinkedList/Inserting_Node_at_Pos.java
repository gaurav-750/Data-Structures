package Linked_List_01_DS;
import java.util.Scanner;

public class Inserting_Node_at_Pos {

    public static void printLL(Node<Integer> head){
        Node<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static int lengthLL(Node<Integer> head){
        int count = 0;

        while (head != null){
            count++;
            head = head.next;
        }

        return count;
    }

    public static Node<Integer> insertingNode(Node<Integer> head, int pos, int x){
        Node<Integer> previousNode = head;

        Node<Integer> newNode = new Node<>(x);
//        System.out.println("newNode address: " + newNode); // @225

        if (pos == 0){
            newNode.next = previousNode;
            return newNode;
        }else {
            int count = 0;
            while (count < pos-1 && previousNode != null){
                previousNode = previousNode.next;
                count++;
            }
            if (previousNode != null){
                Node<Integer> temp_2 = previousNode.next;
                previousNode.next = newNode;
                newNode.next = temp_2;
            }
            return head;
        }

    }

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node<Integer> head = takeInputLL();
        System.out.print("Enter x: ");
        int x = sc.nextInt();
        System.out.print("Enter pos: ");
        int pos = sc.nextInt();

        Node<Integer> result =  insertingNode(head, pos, x);
        printLL(result);
    }
}
