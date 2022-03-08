package Recursion_02;
import java.util.ArrayList;
import java.util.Scanner;

public class Print_Subsets_Of_Array {
    /* APPROACH -
        1. Here we would need to make two calls.
        2. In First call -
            we would pass the array, si+1 and the outputSoFar, hence NOT including the first element
            of the array.
        3. In Second call -
            we pass the array, si+1 and the newOutput (including the first element in the array).
        4. If si exceeds the index of array, we print all the elements present in outputSoFar.
     */

    public static void printSubsetsOfArray(ArrayList<Integer> list, int si, ArrayList<Integer> outputSoFar){
        // base case
        if (si == list.size()){
            for (int elem: outputSoFar){
                System.out.print(elem + " ");
            }
            System.out.println();
            return;
        }

        // creating newOutput which we'll pass in the second recursive call
        ArrayList<Integer> newOutput = new ArrayList<>();
        for (int elem: outputSoFar){
            newOutput.add(elem);
        }
        newOutput.add(list.get(si));

        printSubsetsOfArray(list, si+1, outputSoFar);
        printSubsetsOfArray(list, si+1, newOutput);

        return;
    }

    public static void printSubsetsOfArray(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for (int elem: arr){
            list.add(elem);
        }
        ArrayList<Integer> outputList = new ArrayList<>();

        printSubsetsOfArray(list, 0, outputList);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printSubsetsOfArray(arr);

    }
}
