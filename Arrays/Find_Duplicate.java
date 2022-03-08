package Arrays;

import java.util.Scanner;

public class Find_Duplicate {
    public static int duplicateNumber(int arr[]){
        int i = 0;
        int output = 0;
        while (i < arr.length){
            int j = i+1;
            while (j < arr.length){
                if (arr[i] == arr[j]){
                    output = arr[i];
                    break;
                }
                j++;
            }

            i++;
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int cases = sc.nextInt();

        int g = 0;
        while (g < cases){
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            g++;
            int result = duplicateNumber(arr);
            System.out.println(result);
        }
    }
}
