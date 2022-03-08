package Arrays;


import java.util.ArrayList;

public class array_List {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(20);
        l2.add(30);
        l2.add(40);
        l2.add(50);
        l2.add(60);
        l2.add(70);
        l2.add(80);
        list1.add(10);
        list1.add(9);
        list1.add(8);
        list1.add(7);
        list1.add(6);
        list1.add(5);
        list1.set(0,51);
        list1.set(3,100);

        System.out.println(list1.contains(5));
        System.out.println(l2.indexOf(50));
        System.out.println(l2.remove(2));
        System.out.println(list1.size());

        for (int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        list1.addAll(l2);
        for (int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }
    }
}
