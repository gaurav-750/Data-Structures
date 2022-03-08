package Recursion_02;
import java.util.Scanner;

public class Rat_In_a_Maze {

    // Top Right Down Left
    public static void ratInAMaze(int[][] maze2D, int i, int j, int n, int[][] path2D){
        // base case
        if (i < 0 || j < 0 || i >= n || j >= n || maze2D[i][j] == 0){ // out of bounds, (or)
            return;                                             // it's a blocked cell
        }
        if (i == n-1 && j == n-1){ // You have reached the destination
            path2D[i][j] = 1;
            return;
        }
        if (path2D[i][j] == 1){ // You have already been here, so return!
            return;
        }
        path2D[i][j] = 1; // make the following cell '1' in path2D

        // Move to Top
        ratInAMaze(maze2D, i-1, j, n, path2D);
        if (path2D[n-1][n-1] == 1){
            return;
        }
        // Move to Right
        ratInAMaze(maze2D, i, j+1, n, path2D);
        if (path2D[n-1][n-1] == 1){
            return;
        }
        // Move Downwards
        ratInAMaze(maze2D, i+1, j, n, path2D);
        if (path2D[n-1][n-1] == 1){
            return;
        }
        // Move to left
        ratInAMaze(maze2D, i, j-1, n, path2D);
        if (path2D[n-1][n-1] == 1){
            return;
        }

        return;
    }

    public static boolean ratInAMaze(int[][] maze2D){
        int n = maze2D.length;
        int[][] path2D = new int[n][n];
        ratInAMaze(maze2D, 0, 0, n, path2D);
//        for (int k = 0; k < n; k++) { // printing the path2D
//            for (int l = 0; l < n; l++) {
//                System.out.print(path2D[k][l] + " ");
//            }
//            System.out.println();
//        }

        return path2D[n - 1][n - 1] == 1;
    }

    public static void printPath(int[][] path2D){
        for (int i = 0; i < path2D.length; i++) {
            for (int j = 0; j < path2D.length; j++) {
                System.out.print(path2D[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printRatInAMazeAllPaths(int[][] maze2D, int i, int j, int n, int[][] path2D){
        // base case
        if (i < 0 || j < 0 || i >= n || j >= n || maze2D[i][j] == 0){ // out of bounds (or)
            return;                                             // it's a blocked cell
        }
        if (i == n-1 && j == n-1){// You have reached the destination
//            System.out.println("Destination!");
            path2D[i][j] = 1;
            printPath(path2D); // print the path

            path2D[i][j] = 0;
            return;
        }
        if (path2D[i][j] == 1){// You have already been here, so return!
            return;
        }
        path2D[i][j] = 1; // make the following cell '1' in path2D

        // Move to Top
        printRatInAMazeAllPaths(maze2D, i-1, j, n, path2D);

        // Move to Right
        printRatInAMazeAllPaths(maze2D, i, j+1, n, path2D);

        // Move Downwards
        printRatInAMazeAllPaths(maze2D, i+1, j, n, path2D);

        // Move to Left
        printRatInAMazeAllPaths(maze2D, i, j-1, n, path2D);

        path2D[i][j] = 0;
        return;
    }

    public static void ratInAMazeAllPaths(int[][] maze2D, int n){
        int[][] path2D = new int[n][n];
        printRatInAMazeAllPaths(maze2D, 0, 0, n, path2D);

        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[][] maze2D = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze2D[i][j] = sc.nextInt();
            }
        }

//        System.out.println("Did the rat reach its destination: " + ratInAMaze(maze2D));
        ratInAMazeAllPaths(maze2D, n);
    }
}
