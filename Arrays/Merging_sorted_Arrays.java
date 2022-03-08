package Arrays;
import java.util.Scanner;

public class Merging_sorted_Arrays {
    public static int[] merge(int arr1[] , int arr2[]){
        int i = 0;
        int j = 0;
        int n = arr1.length;
        int m = arr2.length;
        int arr3[] = new int[m+n];
        int k = 0;

        while (i < n && j < m){
            if (arr1[i] < arr2[j]){
                arr3[k] = arr1[i];
                i++;
            }
            else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;

        }
        if (j >= m) {
            while (i < n) {
                arr3[k] = arr1[i];
                i++;
                k++;
            }
        }
        else if (i >= n){
            while (j < m){
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }

        return arr3;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases to be run: ");
        int cases = sc.nextInt();

        int g = 0;
        while (g < cases){
            // 1st Array:
            System.out.print("Enter the size of 1st array: ");
            int n = sc.nextInt();
            int arr1[] = new int[n];
            for (int i = 0; i < n; i++){
                arr1[i] = sc.nextInt();
            }
            // 2nd Array:
            System.out.print("Enter the size of 2nd array: ");
            int m = sc.nextInt();
            int arr2[] = new int[m];
            for (int j = 0; j < m; j++){
                arr2[j] = sc.nextInt();
            }

            g++;
            int result[] = merge(arr1 , arr2);
            for (int a = 0; a < m+n; a++){
                System.out.print(result[a] + " ");
            }
            System.out.println();

        }


    }
}
