package Stacks;
import java.util.Scanner;

public class Stock_Span {

    public static int[] stockSpan(int[] arr){
        int[] arrAns = new int[arr.length];

        int i = 0;
        while (i < arr.length){
            int count = 1;
            int j = i-1;
            while (j >= 0 && arr[j] < arr[i]){
                count++;
                j--;
            }
            arrAns[i] = count;
            i++;
        }

        return arrAns;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = stockSpan(arr);
        for (int k :
                result) {
            System.out.print(k + " ");
        }

    }
}
