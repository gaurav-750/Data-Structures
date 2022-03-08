package Arrays_2D;
import java.util.Scanner;

public class Wave_like_Print {
    public static void wavePrint(int[][] arr2d){
        if (arr2d.length <= 0){
            System.out.println();
        }
        else {
            // Main Solution :-
            int N = arr2d.length ;
            int M = arr2d[0].length;

            int row = -1;
            int col = -1;
            int counter = 0;
            while (counter < M){
                if (row == -1){
                    row++;
                    col++;
                    while (row < N){
                        System.out.print(arr2d[row][col] + " ");
                        row++;
                    }
                    counter++;
                }

                if (row == N && col < M-1){
                    row--;
                    col++;
                    while (row >= 0){
                        System.out.print(arr2d[row][col] + " ");
                        row--;
                    }
                    counter++;
                }

            }


        }

        System.out.println();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases to be run: ");
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

            wavePrint(arr2d);
        }

    }
}
