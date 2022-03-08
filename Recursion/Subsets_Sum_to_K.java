package Recursion_02;
import java.util.ArrayList;
import java.util.Scanner;

public class Subsets_Sum_to_K {

    public static void subsetsSumTok(int[] arr, int si, int k, ArrayList<Integer> outputSoFar){
        // base case
        if (si == arr.length){
            int sumOfSubset = 0;
            // calculating sum of all elements in Subset
            for (int elem: outputSoFar){
                sumOfSubset = sumOfSubset+elem;
            }
            if (sumOfSubset == k){ // if sum is equal to k, print all elements in Subset
                for (int elem: outputSoFar){
                    System.out.print(elem + " ");
                }
                System.out.println();
            }

            return;
        }

        ArrayList<Integer> newOutput = new ArrayList<>();
        for (int elem: outputSoFar){
            newOutput.add(elem);
        }
        newOutput.add(arr[si]);

        subsetsSumTok(arr, si+1, k, outputSoFar);
        subsetsSumTok(arr, si+1, k, newOutput);

        return;
    }

    public static void subsetsSumTok(int[] arr, int k){
        ArrayList<Integer> outputSoFar = new ArrayList<>();
        subsetsSumTok(arr, 0, k, outputSoFar);
    }

    public static int[][] returnSubsetsSumTok(int[] arr, int si, int k, ArrayList<Integer> outputSoFar, int[][] result2D){
        // base case
        if (si == arr.length){
            int sumOfSubset = 0;
            // calculating sum of all elements in Subset
            for (int elem: outputSoFar){
                sumOfSubset = sumOfSubset+elem;
            }
            if (sumOfSubset == k){ // if sum is equal to k, add all elements of Subset in 2D-Array
                int len = outputSoFar.size();
                int indexToBeFound = 0;
                for (int i = 0; i < result2D.length; i++) {
                    if (result2D[i] == null){
                        indexToBeFound = i;
                        break;
                    }
                }
                result2D[indexToBeFound] = new int[len];
                for (int j = 0; j < len; j++) {
                    result2D[indexToBeFound][j] = outputSoFar.get(j);
                }
            }

            return result2D;
        }

        ArrayList<Integer> newOutput = new ArrayList<>();
        for (int elem: outputSoFar){
            newOutput.add(elem);
        }
        newOutput.add(arr[si]);

        returnSubsetsSumTok(arr, si+1, k, outputSoFar, result2D);
        returnSubsetsSumTok(arr, si+1, k, newOutput, result2D);

        return result2D;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        subsetsSumTok(arr, k);

        /*
        int[][] result = returnSubsetsSumTok(arr, k);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
         */

    }
}
