package Linked_List_Recursion_DS;

import javax.print.attribute.IntegerSyntax;
import java.util.Scanner;

public class Delete_Every_N_Nodes {

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

    public static Node<Integer> deleteEveryNNodes(Node<Integer> head, int M, int N){

        Node<Integer> t1 = head;
        Node<Integer> finalHead = head;
        Node<Integer> t2 = null;
        if(M==0 || head == null){
            return null;
        }
        int countM = 1, countN = 1;

        while (head != null){
            while (countM < M && head!=null){
                head = head.next;
                System.out.println("t1 = " + t1.data);
                t1.next = head;
                t1 = t1.next;
                countM++;
            }
            countM = 0;

            while (countN <= N && head!=null) {
                head = head.next;
                t2 = head;
                countN++;
            }
            countN = 1;
        }

        if(t1!=null){
            t1.next = null;
        }

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
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = takeInputLL();

        System.out.print("Enter M: ");
        int M = sc.nextInt();
        System.out.print("Enter N: ");
        int N = sc.nextInt();

        Node<Integer> result = deleteEveryNNodes(head, M, N);
        printLLRecursively(result);
    }
}
