package Arrays;
import java.util.Scanner;

public class Sort_1_and_0 {
    public static void sortZeroesAndOne(int arr[]){
        int i = 0;
        int counter_0 = 0;
        int counter_1 = 0;

        while (i < arr.length){
            if (arr[i] == 0){
                counter_0 ++;
            }
            else {
                counter_1++;
            }

            i++;
        }

        i = 0;
        while (i < counter_0){
            if (arr[i] == 1){
                arr[i] = 0;
            }
            i++;
        }


        while (i < arr.length){
            if (arr[i] == 0){
                arr[i] = 1;
            }
            i++;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases to be run: ");
        int cases = sc.nextInt();

        int g = 0;
        while (g < cases){
            System.out.print("Enter the number of elements in array: ");
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            g++;
            sortZeroesAndOne(arr);
        }


    }
}
