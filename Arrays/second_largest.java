package Arrays;
import java.util.Scanner;

public class second_largest {
    public static int second_Largest(int[] arr){
        int ans = Integer.MIN_VALUE;
        if (arr.length <= 1){
            return ans;
        }

        // Checking whether all elements are equal :
        int n = arr.length;
        boolean equal = true;
        int a = 0;
        int b = 1;
        while(a < n-1){
            if (arr[a] != arr[b]){
                equal = false;
            }
            a++;
            b++;
        }


        if (equal == true) {
            return ans;
        }
        else  {
            int L = Integer.MIN_VALUE;
            int Second_L = Integer.MIN_VALUE;
            int i = 0;
            while (i < arr.length){
                if (arr[i] > L){
                    Second_L = L;
                    L = arr[i];
                }
                else if (arr[i] > Second_L && arr[i] != L){
                     Second_L = arr[i];
                }
                i++;
            }

            return Second_L;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases to be run: ");
        int cases = sc.nextInt();
        int g = 0;
        while (g < cases){
            System.out.print("Enter the size of array: ");
            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            g++;
            int result = second_Largest(arr);
            System.out.println(result);
    }


    }
}
