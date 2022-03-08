package Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Binary_Search {
    public static int binarySearch(int[] arr, int x){
        int start = 0;
        int end = arr.length-1;
        int answer = 0;
        if (arr.length == 0){
            answer = -1;
        }

        while (start <= end){
            int mid = (start+end)/2;
            System.out.println(mid);
            if (arr[mid] < x){
                start = mid+1;
            }
            else if (arr[mid] > x){
                end = mid - 1;
            }
            else if (arr[mid] == x){
                return mid;
            }

        }

       return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the number of test cases to be run: ");
        int cases = sc.nextInt();

        int g = 0;
        while (g < cases){
            System.out.print("Enter x which is to be searched: ");
            int x = sc.nextInt();

            int result = binarySearch(arr , x);
            System.out.println(x + " is present at index " + result);
            g++;
        }

        /*
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        System.out.print("Enter x which is to be searched: ");
        int x = sc.nextInt();

        Collections.sort(list);
        System.out.println(binarySearch(list, x));
*/
    }
}
