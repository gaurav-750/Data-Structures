package Arrays_2D;
import java.util.Scanner;

public class printSpiral {
    public static void print_like_Spiral(int[][] arr2d){
        if (arr2d.length <= 0){
            System.out.println();
        }
        else {
            int N = arr2d.length; int M = arr2d[0].length;
            int row_S = 0 , row_E = N-1 , col_S = 0 , col_E = M-1;
            int count_num = 0;
            int row = 0;
            int col = 0;
            while (count_num < (N*M)){

                // Top Horizontal
                col = col_S;
                while (col <= col_E && count_num < (N*M)){
                    System.out.print(arr2d[row_S][col] + " ");
                    count_num++;
                    col++;
                }
                row_S++;

                // Right Vertical
                row = row_S;
                while (row <= row_E && count_num < (N*M)){
                    System.out.print(arr2d[row][col_E] + " ");
                    count_num++;
                    row++;
                }
                col_E--;

                // Bottom Horizontal
                col = col_E;
                while (col >= col_S && count_num < (N*M)){
                    System.out.print(arr2d[row_E][col] + " ");
                    count_num++;
                    col--;
                }
                row_E--;

                // Left vertical
                row = row_E;
                while (row >= row_S && count_num < (N*M)){
                    System.out.print(arr2d[row][col_S] + " ");
                    count_num++;
                    row--;
                }
                col_S++;

            }
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
            print_like_Spiral(arr2d);

        }



    }
}
