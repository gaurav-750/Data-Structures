package Arrays;
import java.util.Scanner;

public class push_Zeroes_at_end {
    public static void pushZeroesAtEnd(int arr[]) {
        // 1st Method :-
        // Here we r taking help of another empty array which we fill accordingly and the shift all the values from temporary array to our 'arr' array.

//        int i = 0;
//        int n = arr.length;
//        int counter = 0;
//        while (i < n) {
//            if (arr[i] == 0) {
//                counter++;
//            }
//            i++;
//        }
//        i = 0;
//        int non_Zeroes = (n- counter);
//        //Creating a new array :-
//        int temp[] = new int[n];
//        int t = 0;
//        while (i < n){
//            if (arr[i] != 0){
//                temp[t] = arr[i];
//                t++;
//            }
//            i++;
//        }
//        i = 0;
//        t = non_Zeroes;
//        while (i < counter){
//            temp[t] = 0;
//            t++;
//            i++;
//        }
//        for (int j = 0; j < n; j++){
//            arr[i] = temp[t];
//        }
//        for (int j = 0; j < n; j++){
//            System.out.print(arr[i] + " ");
//        }

        // 2nd Method :-
        // Here we r making changes in the array itself, hence not using another for the same.

        int i = 0;
        int j = 0;
        int n = arr.length;
        int temp;
        while (i < n){
            if (arr[i] != 0){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
            i++;
        }
        for (int k = 0; k < n; k++){
            System.out.print(arr[k] + " ");
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
            int arr[] = new int[n];

            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            g++;
            pushZeroesAtEnd(arr);
        }


    }
}
