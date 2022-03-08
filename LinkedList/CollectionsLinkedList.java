package Linked_List_Recursion_DS;
import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.Scanner;

public class CollectionsLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>(); // object created named list
        // Linked list which we r using here is Doubly Linked List!

//        list.add(10);
//        list.add(20); // 20 would be added after 10
//        list.add(30); // 30 would be added after 20
//        list.add(1,100);
//        list.addFirst(11); // inserts element at the beginning of Linked List
//        list.addFirst(200);
//        System.out.println(list.get(1));
//        System.out.println(list.size());
//
//        list.set(0,55); // to replace any element at a particular index
//        list.remove(2); // to remove any element from the Linked List
////        list.isEmpty(); // checks if the LL is empty or not
//
//        System.out.println(list.size());
//        for (int i = 0; i < list.size(); i++){
//            System.out.print(list.get(i) + " ");
//        }
//
//        for (int j = 0; j < 5; j++) {
//            list.add(sc.nextInt());
//        }
//        System.out.println();
//        for (int j:
//             list) {
//            System.out.print(j + " ");
//        } // printing the Linked List

        LinkedList<String> listStr = new LinkedList<>();
        listStr.add("1");
        listStr.add("2");
        listStr.add("3");
        listStr.add("4");

        for (String elem:
             listStr) {
            System.out.print(elem + " ");
        }
                // How to take input of a Linked List :-
        while (true){
            int element = sc.nextInt();
            if (element == -1){
                break;
            }else {
                list.add(element);
            }
        }

        for (int k :   // printing Linked List
                list) {
            System.out.print(k + " ");
        }

    }
}
