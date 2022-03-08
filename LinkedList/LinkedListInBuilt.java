package Linked_List_01_DS;
import java.util.LinkedList;

public class LinkedListInBuilt {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);

        System.out.println(ll);

        ll.addFirst(11);
        ll.addLast(40);
        System.out.println(ll);
        ll.remove(2);

        System.out.println(ll);
    }
}
