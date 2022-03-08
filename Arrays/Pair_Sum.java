package Arrays;

import java.util.Scanner;

public class Pair_Sum {
    public static int pairSum(int arr[] , int x){
        int i = 0;
        int counter = 0;
        while (i < arr.length){
            int j = i+1;
            while (j < arr.length){
                if (arr[i] + arr[j] == x){
                    counter = counter + 1;
                }
                j++;
            }

            i++;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int cases = sc.nextInt();

        int g = 0;
        while(g < cases){
            System.out.print("Enter the size of array: ");
            int n = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter x: ");
            int x = sc.nextInt();

            g++;
            int result = pairSum(arr , x);
            System.out.println(result);
        }


    }
}
