package Graphs;
import java.util.Scanner;

// Date: 17-11-2021
public class Implementation_AdjacencyMatrix {
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


    }
}
/*
    Assumptions:
    1. We'll take numeric inputs.
    2. If n = 4 (4 vertices), our numbers would range from 0 to 3, i.e for n our
        vertices would range from 0 to (n-1).
 */

// In 'adjacency Matrix', if there exist a connection between 2 vertices, we store 1 otherwise 0.