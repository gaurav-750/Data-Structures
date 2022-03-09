package Graphs;
import java.util.Arrays;
import java.util.Scanner;

public class Prims_Algorithm {

    public static int findVertexWithMinWeight(int[] weightArr, boolean[] visitedArr){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < weightArr.length; i++) {
            if (weightArr[i] < min && !visitedArr[i]){
                min = weightArr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void primsAlgorithm(int[][] adMat, int n){
        // We need a visited Array - to check whether a vertex is visited (or) not
        boolean[] visitedArr = new boolean[n];

        // A Parent array - to store parent of every vertex
        int[] parentArr = new int[n];
        // Lets keep source as 0
        parentArr[0] = -1; // Initially, parent of source is -1

        // A weight Arr - to keep a track on weights
        int[] weightArr = new int[n];
        // Initially, weight for every vertex except source(0) will be infinity:
        for (int i = 1; i < n; i++) {
            weightArr[i] = Integer.MAX_VALUE;
        }

        int count = 0;
        while (count < (n-1)){
            int currentVertex = findVertexWithMinWeight(weightArr, visitedArr);
            visitedArr[currentVertex] = true; // make the currentVertex visited

            // Explore neighbours of currentVertex
            for (int i = 0; i < n; i++) {
                if (adMat[currentVertex][i] != 0 && !visitedArr[i]){ // there is edge between them
                    if (weightArr[i] > adMat[currentVertex][i]){ // update weight and parent
                        weightArr[i] = adMat[currentVertex][i];
                        parentArr[i] = currentVertex;
                    }
                }

            }

            count++;
        }

        // printing the MST:
        for (int i = 1; i < n; i++) {
            if (parentArr[i] < i){
                System.out.println(parentArr[i] + " " + i + " " + weightArr[i]);
            }else {
                System.out.println(i + " " + parentArr[i] + " " + weightArr[i]);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking Input:
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        // creating an adjacency Matrix for storing graph
        int[][] adMat = new int[n][n];
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();

            adMat[v1][v2] = weight;
            adMat[v2][v1] = weight;
        }

        primsAlgorithm(adMat, n);
    }

}
