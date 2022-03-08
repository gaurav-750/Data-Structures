package Arrays_2D;
import java.util.Scanner;

public class Largest_Row_or_Column {
    public static void largestRowColumn(int[][] arr2d){
        if (arr2d.length <= 0 ){
            System.out.println("row " + 0 + " " + Integer.MIN_VALUE );
        }
        else {
            // For rows :-
            int max_row_sum = Integer.MIN_VALUE;
            int rows = arr2d.length;
            int cols = arr2d[0].length;
            String str_final_row = "";
            for (int i = 0; i < rows; i++){
                int sum = 0;
                for (int j = 0; j < cols; j++){
                    sum = sum + arr2d[i][j];
                }
                if (sum > max_row_sum){
                    max_row_sum = sum;
                    str_final_row = "row " + i + " " + max_row_sum;
                }
            } // End of i for Loop
            //System.out.println(max_row_sum);

            // For columns :-
            int max_col_sum = Integer.MIN_VALUE;
            String str_final_col = "";
            for (int j = 0; j < cols; j++){
                int sum = 0;
                for (int i = 0; i < rows; i++){
                    sum = sum + arr2d[i][j];
                }
                if (sum > max_col_sum){
                    max_col_sum = sum;
                    str_final_col = "column " + j + " " + max_col_sum;
                }
            } // End of j for Loop
            //System.out.println(max_col_sum);


            if (max_row_sum > max_col_sum){
                System.out.println(str_final_row);
            }
            else if (max_row_sum == max_col_sum){
                System.out.println(str_final_row);
            }
            else {
                System.out.println(str_final_col);
            }
        }




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
            largestRowColumn(arr2d);

        }


    }
}
