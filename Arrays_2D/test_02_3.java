package Arrays_2D;
import java.util.Scanner;

public class test_02_3 {
    public static void leaders(int[] arr){
        int n = arr.length;

        int i = 0;
        int current_element = 0;
//        System.out.println(n);

        while (i < arr.length){
            boolean isLeader = true;
            current_element = arr[i];
            int j = i+1;

            while (j < arr.length){ // start of j loop
                if (current_element < arr[j]) {
                    isLeader = false;
                    break;
                }
                j++;
            } // end of j loop

            if (isLeader == true){
                System.out.print(arr[i] + " ");
            }

            i++;
        } // end of i loop

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        leaders(arr);

    }
}
