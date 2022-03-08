package Arrays_2D;
import java.util.Scanner;

public class Sum_of_Boundaries_diagonals {
    public static void boundaries_Diagonals(int[][] mat){
        int n = mat.length;
        int sum = 0;
        int row = 0, col = 0;
        while(col < n){
            sum = sum + mat[row][col];
            mat[row][col] = 0;
            col++;
        }

        row = 1;
        col = n-1;
        while (row < n){
            sum = sum + mat[row][col];
            mat[row][col] = 0;
            row++;
        }

        row = n-1; col = 0;
        while (col < n){
            sum = sum + mat[row][col];
            mat[row][col] = 0;
            col++;
        }

        row = 1; col = 0;
        while (row < n){
            sum = sum + mat[row][col];
            mat[row][col] = 0;
            row++;
        }

        row = 1; col = 1;
        while (row < n){
            sum = sum + mat[row][col];
            mat[row][col] = 0;
            row++ ; col++;
        }

        row = n-2; col = 1;
        while (col < n && row >= 0){
            sum = sum + mat[row][col];
            mat[row][col] = 0;
            row--;
            col ++;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases to be run: ");
        int cases = sc.nextInt();
        int g = 0;

        while (g < cases){
            System.out.print("Enter N: ");
            int N = sc.nextInt();
            int[][] arr2d = new int[N][N];

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    arr2d[i][j] = sc.nextInt();
                }
            }

            g++;
            boundaries_Diagonals(arr2d);


        }


    }
}
