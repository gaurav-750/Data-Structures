package Graphs;
import java.util.Arrays;
import java.util.Scanner;

public class DepthFirstTraversal {
    // i - current row Number
    public static void depthFirstTraversal(int[][] adMat, int i, boolean[] trackArr){

        trackArr[i] = true;
        System.out.print(i + " "); // printing the element

        for (int j = 0; j < adMat.length; j++) {
            if (!trackArr[j] && adMat[i][j] == 1){// if the element is already present in list, we don't need to print that again
                depthFirstTraversal(adMat, j, trackArr);
            }

        }

        return;
    }

    public static void DFS(int[][] adMat, int n){

        boolean[] trackArr = new boolean[adMat.length];

        for (int i = 0; i < n; i++) {
            if (!trackArr[i]){
                depthFirstTraversal(adMat, i, trackArr);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt(); // n = number of vertices
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt(); // e = number of edges

        int[][] adMat = new int[n][n]; // creating a 2D-Matrix of n*n size

        // Taking inputs for all the edges:
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            // There exist a connection between v1 and v2, that means there also exist a connection between
            // v2 and v1, hence we store 1 at both the cells in the matrix.
            adMat[v1][v2] = 1;
            adMat[v2][v1] = 1;
        }


        DFS(adMat, n);

    }
}
