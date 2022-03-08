package HashMaps;
import java.util.HashMap;
import java.util.Scanner;

public class printIntersection {

    /* Algorithm:
        1. Build Map for array 1:
        2. For every element in array2:
            1. Check whether element is present in Map. // that means it was in arr1
                1. If yes, print the element.
                2. Find its value.
                3. Put the key(elem) and value-1 again into the map.
            2. Continue.
     */
    public static void printIntersectionUsingHashMap(int[] arr1, int[] arr2){

        HashMap<Integer, Integer> map = new HashMap<>();

        // Building map for array 1:
        for (int elem: arr1){
            if (map.containsKey(elem)){
                int value = map.get(elem);
                map.put(elem, value+1);
            }else {
                map.put(elem, 1);
            }
        }


        for (int elem: arr2){
            if (map.containsKey(elem)){
             // element in present in arr1:
                int freq = map.get(elem);
                if (freq > 0){
                    System.out.println(elem + " ");
                    map.put(elem, freq-1);
                }
            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input for first array:
        System.out.print("Enter the size of array 1: ");
        int n1 = sc.nextInt();

        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input for second array:
        System.out.print("Enter the size of array 2: ");
        int n2 = sc.nextInt();

        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        printIntersectionUsingHashMap(arr1, arr2);

    }
}
