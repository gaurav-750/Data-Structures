package Linked_List_01_DS;
import java.util.ArrayList;
import java.util.Scanner;

public class Remove_Consecutive_Duplicates {

    public static ArrayList<Integer> removeConsDup(int[] arr){
        ArrayList<Integer> arrL = new ArrayList<>();
        arrL.add(arr[0]);

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[j-1]){
                arrL.add(arr[j]);
            }
        }

        return arrL;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> result = removeConsDup(arr);
        for (int k:
             result) {
            System.out.print(k + " ");
        }

    }
}
