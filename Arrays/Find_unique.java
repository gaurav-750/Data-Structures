package Arrays;
import java.util.Scanner;

public class Find_unique {
    public static void findUnique(int[] arr){
        int i = 0;
        while (i < arr.length){
            boolean found = true;
            int j = 0;
            while (j < arr.length){
                if (i == j){
                    if (i == arr.length-1){
                        System.out.print(arr[i]);
                        System.out.println();
                    }
                    else {
                        j = j + 1;
                    }

                }
                if (arr[i] == arr[j]) {
                    found = false;
                    break;
                }

                j++;
            }

            if (found == true){
                System.out.println(arr[i]);
                System.out.println();
            }

            i++;
        }

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
            g++;
            findUnique(arr);
        }


    }
}
