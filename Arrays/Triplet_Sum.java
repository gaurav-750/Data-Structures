package Arrays;
import java.util.Scanner;

public class Triplet_Sum {
    public static int findTriplet(int arr[] , int x){
        int i = 0;
        int counter = 0;

        while (i < arr.length){
            int j = i+1;
            while (j < arr.length){
                int k = j+1;
                while (k < arr.length){
                    if (arr[i] + arr[j] + arr[k] == x){
                        counter = counter + 1;
                        System.out.print("(" + arr[i] + "," + arr[j] + "," + arr[k] + ")");

                    }
                    k++;
                }
                j++;
            }
            i++;
        }
        System.out.println();
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int cases = sc.nextInt();

        int g = 0;
        while (g < cases){
            System.out.print("Enter the size of array: ");
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter x: ");
            int x = sc.nextInt();

            g++;
            int result = findTriplet(arr , x);
            System.out.println(result);
        }


    }
}
