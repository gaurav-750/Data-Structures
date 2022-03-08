package Linked_List_01_DS;
import java.util.ArrayList;

public class Array_List {
    public static void main(String[] args) {

        ArrayList<Integer> arrL = new ArrayList<>();

        arrL.add(0);
        arrL.add(10);
        arrL.add(20);
        arrL.add(30);
        arrL.add(40);
        arrL.add(50);
        arrL.add(40);
        arrL.add(40);
        arrL.add(60);
        arrL.add(1,100);
        System.out.println(arrL.get(2));
//        arrL.add(9,200);

        System.out.println(arrL.size());
        System.out.println(arrL); // to print arrayList

        arrL.set(1,1);  // To 'REPLACE' a particular element at a particular Index
        arrL.remove(3);
        Integer i = 40;
        arrL.remove(i); // remove a particular object(element)

        System.out.println(arrL);

                // For each Loop -
        // here 'j' holds the value of arrL elements, unlike in for loop where it holds the index number
        // For each element j in arrL -
        for (int j : arrL){
            System.out.print(j + " ");
        }
        System.out.println();
//        int[] arr = {1,2,3,4,5,5,6,6};
//        for (int k:
//             arr) {
//            System.out.print(k + " ");
//        }


        ArrayList<Integer> arrL_2 = new ArrayList<>();
        arrL_2.add(0,30);
        arrL_2.add(1,20);
        arrL_2.add(2,10);
        arrL_2.remove(1);


        System.out.println(arrL_2.get(0));
        System.out.println(arrL_2.get(1));
        System.out.println(arrL_2.get(2));
    }
}
