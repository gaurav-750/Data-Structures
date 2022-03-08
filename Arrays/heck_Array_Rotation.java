package Arrays;
import java.util.Scanner;

public class heck_Array_Rotation {
    public static int check_Rotation(int[] arr){
        int ans = 0;
        if (arr.length>0){
            // Creating a new array and storing the values of original's array into this :
            int[] arr_new = new int[arr.length];
            for (int i = 0; i < arr.length; i++){
                arr_new[i] = arr[i];
            }

            // Sorting the array :-
            int max;
            int biggerLoop = 0;
            int n = arr.length;
            while (biggerLoop < arr.length){
                int i = 0; // 1st Element
                int j = 1; // 2nd Element
                while (i < arr.length && j < arr.length){
                    if (arr[i] > arr[j]){
                        max = arr[i];
                        arr[i] = arr[j];
                        arr[j] = max;
                    }

                    i++;
                    j++;
                }
                n = n-1;
                biggerLoop++;
                // Array Sorted
            }
            // Final Step :-
            int first_ele = arr[0];
            int i = 0;
            ans = 0;
            while (i < arr.length){
                if (first_ele == arr_new[i]){
                    ans = i;
                }
                i++;
            }

        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases to be run: ");
        int cases = sc.nextInt();
        int g = 0;

        while (g < cases){
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            g++;
            check_Rotation(arr);



        }



    }
}
