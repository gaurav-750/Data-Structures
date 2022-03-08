package Linked_List_01_DS;
import java.util.*;

public class Palindrome_linkedList {

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

    public static boolean checkPalindrome(Node<Integer> head) {
        int length = lengthLL(head);
        int i = 0, j = 0;
//        if (length % 2 ==0){
//            j = length/2;
//        }else {
//            j = length/2 + 1;
//        }

        ArrayList<Integer> arrL_1 = new ArrayList<>();
        ArrayList<Integer> arrL_2 = new ArrayList<>();

        Node<Integer> currentNode = head;
        while (i < length / 2) {
            arrL_1.add(currentNode.data);
            currentNode = currentNode.next;
            i++;
        }

        if (length%2 != 0){
            currentNode = currentNode.next;
        }
        while (j < length / 2) {
            arrL_2.add(j, currentNode.data);
            currentNode = currentNode.next;
            j++;
        }

        i =0;
        j = (length/2)-1;
        while (i < length/2){
            if (arrL_1.get(i) != arrL_2.get(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static boolean checkPal(Node<Integer> head){
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        int length = lengthLL(head);
        int count = 0;

        while (count < length/2){ // adding elements in stack
            stack.add(head.data);
            head = head.next;
            count++;
        }

        if (length % 2 != 0){ // if length is odd
            head = head.next;
            length--;
        }
        while (count < length){ // adding elements in queue
            queue.add(head.data);
            head = head.next;
            count++;
        }

        int i = 0;
        while (i < length/2){
            if (!stack.pop().equals(queue.poll())){ // checking whether elements are same
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputLL();

//        boolean result = checkPalindrome(head);
        boolean result = checkPal(head);
        System.out.println(result);
    }
}
