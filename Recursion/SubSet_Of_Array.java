package Recursion_02;
import java.util.ArrayList;
import java.util.Scanner;

public class SubSet_Of_Array {

    public static void print2dArray(int[][] arr2D){
        System.out.println("2dArray: ");
        for (int i = 0; i < arr2D.length; i++) {
            if (arr2D[i] == null){
                System.out.println("null");
                continue;
            }
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
        Approach -
        1. The one which we used for printing Subsets of a given array - just with some modifications.
        2. We already took a 2D-Array, with initial size 2^(arr.length).
        3. Once we hit the base case, we just find the length of the outputSoFar.
        4. Then we create an array of the same length and push all the elements from outputSoFar
        to the array we created and place it in 2D-Array.
        5. Finally, return the 2D-Array.
     */

    public static int[][] subsetOfArrayNew(int[] arr, int si, ArrayList<Integer> outputSoFar, int[][] result2D){
        // base case
        if (si == arr.length){
            int len = outputSoFar.size();
            int indexToBeFound = 0;
            for (int i = 0; i < result2D.length; i++) {
                if (result2D[i] == null){
                    indexToBeFound = i;
                    break;
                }
            }

//            System.out.println("indexToBeFound = " + indexToBeFound);
            result2D[indexToBeFound] = new int[len];
            for (int i = 0; i < len; i++) {
                result2D[indexToBeFound][i] = outputSoFar.get(i);
            }

            return result2D;
        }

        // creating newOutput which we'll pass in the second recursive call
        ArrayList<Integer> newOutput = new ArrayList<>();
        for (int elem: outputSoFar){
            newOutput.add(elem);
        }
        newOutput.add(arr[si]);


        subsetOfArrayNew(arr, si+1, outputSoFar, result2D);
        subsetOfArrayNew(arr, si+1, newOutput, result2D);

        return result2D;
    }

    public static int[][] subsetsOfArray(int[] arr){
        ArrayList<Integer> outputSoFar = new ArrayList<>();
        int len = (int) Math.pow(2.0, arr.length);
        int[][] result2D = new int[len][];

        return subsetOfArrayNew(arr, 0, outputSoFar, result2D);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] result = subsetsOfArray(arr);
        print2dArray(result);

    }
}
