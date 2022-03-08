package Arrays;
import java.util.Scanner;

public class Array_Intersection {
    public static void intersections(int arr1[] , int arr2[]){
        int i = 0;
        while (i < arr1.length){
            int j = 0;
            while (j < arr2.length){
                if (arr1[i] == arr2[j]){
                    System.out.print(arr1[i] + " ");
                    arr2[j] = Integer.MIN_VALUE;
                    break;
                }
                j++;
            }

            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int cases = sc.nextInt();

        int g = 0;
        while(g < cases){
            System.out.print("Enter the size of array 1: ");
            int n1 = sc.nextInt();
            int arr1[] = new int[n1];
            //taking input for 1st Array :
            for (int i = 0; i < n1; i++){
                arr1[i] = sc.nextInt();
            }

            System.out.print("Enter the size of array 2: ");
            int n2 = sc.nextInt();
            int arr2[] = new int[n2];
            //taking input for 2nd Array :
            for (int j = 0; j < n2; j++){
                arr2[j] = sc.nextInt();
            }
            g++;
            intersections(arr1 , arr2);

        }
    }
}
