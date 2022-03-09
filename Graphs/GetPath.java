package Graphs;
import java.util.*;

public class GetPath {
    
    public static ArrayList<Integer> getPathDfs(int[][] adMat, boolean[] visitedArr, ArrayList<Integer> list, int v, int v2){

        visitedArr[v] = true;// as we have arrived to this row, assign true to its index.
        if (v == v2){ // We have reached the destination
            /*
                Create a new ArrayList.
                Add the current/destination vertex and return it.
             */
            ArrayList<Integer> smallList = new ArrayList<>();
            smallList.add(v);
            return smallList;
        }

        for (int i = 0; i < adMat.length; i++) {
            if (adMat[v][i] == 1 && !visitedArr[i]){// for path there must be a connection between the current vertex and the current column
                ArrayList<Integer> sOutput = getPathDfs(adMat, visitedArr, list, i, v2);

                if (sOutput != null){
                    sOutput.add(v);
                    return sOutput;
                }
            }
        }

        return null;
    } 

    public static ArrayList<Integer> getPathBfs(int[][] adMat, int v1, int v2){
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        queue.add(v1);
        map.put(v1, -1); // Let us say the parent of source vertex v1 is -1.

        // Creating a boolean array to keep a track on elements which are already visited and which are not.
        boolean[] visitedArr = new boolean[adMat.length];
        visitedArr[v1] = true;
        boolean foundv2 = false;

        while (!queue.isEmpty()){
            int parent = queue.poll();

            // adding its neighbours/adjacent elements
            for (int i = 0; i < adMat.length; i++) {
                if (adMat[parent][i] == 1 && !visitedArr[i]){
                    queue.add(i);
                    map.put(i, parent);
                    visitedArr[i] = true;

                    if (i == v2){ // if we find the destination, we update foundv2 as true
                        foundv2 = true;
                    }
                }
            }

        }

        if (!foundv2){// if we haven't found v2, return null
            return null;
        }

        // If we found v2, create an ArrayList, update all values of path
        // using HashMap map.
        ArrayList<Integer> path = new ArrayList<>();
        path.add(v2);
        int currentVertex = v2;
        int parent;

        while (currentVertex != v1){
            parent = map.get(currentVertex);
            path.add(parent);
            currentVertex = parent;
        }

        return path;
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
        int v2 = sc.nextInt();

        boolean[] visitedArr = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();
        // Get Path - Using DFS
//        ArrayList<Integer> output = getPathDfs(adMat, visitedArr, list, v1, v2);

//        if (output != null){
//            System.out.println(output);
//        }

        // Get Path - Using BFS
        ArrayList<Integer> output = getPathBfs(adMat, v1, v2);
        if (output != null){
            for (int elem: output){
                System.out.print(elem + " ");
            }
        }

    }

}
