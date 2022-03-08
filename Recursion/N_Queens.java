package Recursion_02;
import java.util.Scanner;

public class N_Queens {

    public static boolean canIPlaceHere(int[][] board2D, int n, int row, int col){
        // check if any Queen block our path in 'Column'
        int i = 0;
        while (i < n){
            if (board2D[i][col] == 1){
                return false;
            }
            i++;
        }

        // Check if any Queen block our path in 'Left Diagonal'
        int rowNum = row;
        int colNum = col;
        while (rowNum >= 0 && colNum >= 0){// check in the upper half
            if (board2D[rowNum][colNum] == 1){
                return false;
            }
            rowNum--;
            colNum--;
        }
        rowNum = row;
        colNum = col;
        while (rowNum < n && colNum < n){// check in the lower half
            if (board2D[rowNum][colNum] == 1){
                return false;
            }
            rowNum++;
            colNum++;
        }

        // Check if the Queen blocks our path in the 'Right Diagonal'
        rowNum = row;
        colNum = col;
        while (rowNum >= 0 && colNum < n){ // check in the upper half
            if (board2D[rowNum][colNum] == 1){
                return false;
            }
            rowNum--;
            colNum++;
        }

        rowNum = row;
        colNum = col;
        while (rowNum < n && colNum >= 0){ // check in the lower half
            if (board2D[rowNum][colNum] == 1){
                return false;
            }
            rowNum++;
            colNum--;
        }

        return true;
    }

    public static void printBoard(int[][] board2D, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board2D[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void nQueens(int[][] board2D, int n, int row, int col){
        // base case
        if (row == n){ // You have filled all the rows
            printBoard(board2D, n);
            return;
        }

        // First make sure if you can actually place a queen at that point.
        boolean canIPlace = false;
        while (!canIPlace && col < n) {
            canIPlace = canIPlaceHere(board2D, n, row, col);
            col++;
        }
        if (!canIPlace && col == n){// If you failed to put Queen in a row, then 'Back-Track'
            return;
        }

        col = col-1;
        board2D[row][col] = 1;// Queen placed

        nQueens(board2D, n, row+1, 0); // Call on the next row as you have placed the Queen in position in the current row
//        System.out.println("r = " + row);
//        System.out.println("c = " + col);

        //You failed to put Queen in the current row, hence you are here (1 row backward)
        board2D[row][col] = 0; // Remove the Queen from the current Position
        nQueens(board2D, n, row, col+1); // Call on the next Column
        return;
    }

    public static void placeNQueens(int n){
        int[][] board2D = new int[n][n]; // Create an n*n board (a 2D Array)

        nQueens(board2D, n, 0, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        placeNQueens(n);
    }

}
