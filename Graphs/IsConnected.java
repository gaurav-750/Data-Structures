package Graphs;
import java.util.*;
import java.util.Scanner;

public class IsConnected {

    public static boolean isConnected(int[][] adMat){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedArr = new boolean[adMat.length];

        queue.add(0);
        visitedArr[0] = true;
        while (!queue.isEmpty()){
            int currentVertex = queue.poll();

            for (int i = 0; i < adMat.length; i++) {
                if (adMat[currentVertex][i] == 1 && !visitedArr[i]){
                    queue.add(i);
                    visitedArr[i] = true;
                }
            }
        }

        for (int i = 0; i < visitedArr.length; i++) {
            if (!visitedArr[i]){
                return false;
            }
        }

        return true;
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

        if (n > 0) {
            System.out.println("Is Connected: " + isConnected(adMat));
        }
    }
}
