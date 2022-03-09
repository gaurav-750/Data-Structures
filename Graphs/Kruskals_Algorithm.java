package Graphs;
import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    // data members
    int v1;
    int v2;
    int weight;

            // Constructor
    public Edge(int v1, int v2, int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Kruskals_Algorithm {

    public static int findParent(int v, int[] parentArr){
        if (v == parentArr[v]){
            return v;
        }

        int parent = findParent(parentArr[v], parentArr);
        return parent;
    }

    public static Edge[] kruskalsAlgo(Edge[] edgesArr, int n){
        // sorting Weights (and edges) in ascending order
        // So our array will get sort in ascending order of weights with respective vertices sharing edges
        Arrays.sort(edgesArr);

        // creating an array of Edges which we'll eventually return;
        Edge[] mst = new Edge[n-1];// 'mst' will have n-1 edges

        // creating a ParentArray to keep a track of parents of all the vertices
        int[] parentArr = new int[n];
        // initial values will be: parent of 0 will be 0, 1 will be 1, and so on..
        for (int i = 0; i < n; i++) {
            parentArr[i] = i;
        }

        int count = 0, i = 0;
        while (count < (n-1)){
            Edge currentEdge = edgesArr[i];

            // we need to find the parent of both the vertices
            int v1Parent = findParent(currentEdge.v1, parentArr);
            int v2Parent = findParent(currentEdge.v2, parentArr);

            if (v1Parent != v2Parent){ // include the currentEdge
                mst[count] = currentEdge;
                count++;

                // update the parent of v1 to parent of v2
                parentArr[v1Parent] = v2Parent;
            }

            i++;
        }

        return mst;
    }

    public static void main(String[] args) {
        /*  We'll implement it through Edge List.
            We have created a class Edge - which has three data members -
                v1, v2 and weight. So we basically are storing 2 vertices which share an edge and weight.
         */

        // Taking Input (in Edge List)
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        // creating an array named 'edgesArr' of type Edge.
        Edge[] edgesArr = new Edge[e];
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt(); // input for v1
            int v2 = sc.nextInt(); // input for v2
            int weight = sc.nextInt(); // input for weight

            Edge ed = new Edge(v1, v2, weight); // creating an object of Edge.
            edgesArr[i] = ed; // Finally, storing it in edgesArr.
        }

        Edge[] mst = kruskalsAlgo(edgesArr, n); // function call

        // Printing the Minimum Spanning tree
        for (Edge edge : mst) {
            if (edge.v1 < edge.v2) {
                System.out.println(edge.v1 + " " + edge.v2 + " " + edge.weight);
            } else {
                System.out.println(edge.v2 + " " + edge.v1 + " " + edge.weight);
            }
        }

    }
}
