package Arrays_2D;
import java.util.Scanner;

public class Arrays_Row_wise_sum {
    public static void row_wise_sum(int[][] arr2d){
        int i = 0;
        while (i < arr2d.length){
            int sum = 0;
            int j = 0;
            while (j < arr2d[0].length){
                sum = sum + arr2d[i][j];
                j++;
            }
            System.out.print(sum + " ");
            i++;
        }
        System.out.println();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int cases = sc.nextInt();

        int g = 0;
        while (g < cases){
            System.out.print("Enter the number of rows: ");
            int N = sc.nextInt();
            System.out.print("Enter the number of columns: ");
            int M = sc.nextInt();

            int[][] arr2d = new int[N][M];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    arr2d[i][j] = sc.nextInt();
                }
            }
             g++;
            row_wise_sum(arr2d);

        }

    }
}
