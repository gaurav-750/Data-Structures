package Arrays;
import java.util.Scanner;

public class Arrays_with_Functions {
    public static int[] takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        int i = 0;
        while (i < n){
            System.out.print("Enter element for " + i + " index number: ");
            arr[i] = sc.nextInt();
            i++;
        }
        return arr;
    }

    public static void printArray(int arr[]){
        int i = 0;
        int n = arr.length;
        while (i < n){
            System.out.print(arr[i] + " ");
            i++;
        }
    }

    public static void main(String[] args) {

        int arr[] = takeInput(); // taking user's input by calling a function names takeInput
        printArray(arr);  // printing array by calling another function.
    }
}
