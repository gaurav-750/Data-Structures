package Arrays_2D;
import java.util.Scanner;

public class test_02_1 {
    public static void print2DArray(int [][] input){
        if (input.length <= 0){
            System.out.println();
        }
        else {
            int n = input.length; int m = input[0].length;
            int i = 0;

            while (i < input.length){
                int loop = 0;
                while (loop < n){
                    int j = 0;
                    while (j < m){
                        System.out.print(input[i][j] + " ");
                        j++;
                    }
                    System.out.println();
                    loop++;
                }

                i++;
                n--;
            }
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter the number of columns: ");
        int m = sc.nextInt();

        int[][] arr2d = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arr2d[i][j] = sc.nextInt();
            }
        }

        print2DArray(arr2d);

    }
}
