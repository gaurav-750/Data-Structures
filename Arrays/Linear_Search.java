package Arrays;
import java.util.Scanner;

public class Linear_Search {

    public static int linearSearch(int arr[] , int x){
        int i = 0;
        boolean gotIt = true;

        while (i < arr.length){
            if (arr[i] == x){
                gotIt = false;
                return i;
            }
            i++;
        }

        return -1;
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
             //   System.out.print("Enter element at " + i + " th index number: ");
                arr[i] = sc.nextInt();
                //System.out.print(" ");
            }

            //System.out.print("Enter number x to be searched: ");
            int x = sc.nextInt();
            int index = linearSearch(arr , x);
            System.out.println("Element is present at index " + index);
            g++;
        }

    }
}
