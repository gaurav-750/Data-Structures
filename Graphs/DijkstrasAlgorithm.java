package Graphs;
import java.util.Scanner;

public class DijkstrasAlgorithm {

    public static int findVertexWithMinimumDistance(int[] distanceArr, boolean[] visitedArr){
        int minVertex = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < distanceArr.length; i++) {
            if (minDistance > distanceArr[i] && !visitedArr[i]){
                minDistance = distanceArr[i];
                minVertex = i;
            }
        }

        return minVertex;
    }

    public static void dijkstrasAlgo(int[][] adMat, int n){
        // creating a visited Array
        boolean[] visitedArr = new boolean[n];

        // creating a distance array - to keep a track on distances
        int[] distanceArr = new int[n];
        // initialising values - Initial distance of every vertex(except source) would be infinity
        for (int i = 1; i < n; i++) {
            distanceArr[i] = Integer.MAX_VALUE;
        }

        int count = 0;
        while (count < (n-1)){
            // pick the vertex with minimum distance:
            int currentVertex = findVertexWithMinimumDistance(distanceArr, visitedArr);
            visitedArr[currentVertex] = true; // mark the currentVertex as visited

            // Explore the neighbours of currentVertex
            for (int i = 0; i < n; i++) {
                if (adMat[currentVertex][i] > 0 && !visitedArr[i]){
                    // there is an edge between them and i is unvisited neighbour of currentVertex

                    // calculate distance from source to reach i via currentVertex
                    int currentDistance = distanceArr[currentVertex] + adMat[currentVertex][i];
                    if (distanceArr[i] > currentDistance){
                        // the current distance of i has greater distance than their current distance
                        distanceArr[i] = currentDistance;
                    }
                }

            }

            count++;
        }

        // printing the distance values for all vertices:
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + distanceArr[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        int[][] adMat = new int[n][n];
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            int weight = sc.nextInt();
            adMat[v1][v2] = weight;
            adMat[v2][v1] = weight;
        }

        dijkstrasAlgo(adMat, n);
    }
}
/*
    Dijkstras Algorithm only works for positive weights.
 */