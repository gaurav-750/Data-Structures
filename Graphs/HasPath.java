package Graphs;
import java.util.Scanner;

public class HasPath {

    public static boolean hasPath(int[][] adMat, boolean[] visitedArr, int v, int v2){
        visitedArr[v] = true;

        if (v == v2){// means the connection is present
                return true;
        }
        for (int i = 0; i < adMat.length; i++) {
            if (adMat[v][i] == 1 && !visitedArr[i]) { // if there is a connection and if the row is not visited yet
                boolean smallAns = hasPath(adMat, visitedArr, i, v2);

                if (smallAns){
                    return true;
                }
            }
        }

        return false;
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

        System.out.print("Enter v1: ");
        int v1 = sc.nextInt();
        System.out.print("Enter v2: ");
        int v2 = sc.nextInt();;

        boolean[] visitedArr = new boolean[n];
        System.out.println("Is Path present: " + hasPath(adMat, visitedArr, v1, v2));
    }
}
