package Graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstTraversal {

    /*
        APPROACH:
        1. Since, BFS is like Level-Order traversal in trees, we would definitely need
            a Queue. We would also need a arr, say trackArr of type boolean to keep a check
            whether we have already visited a particular element.
            If we visit an element, we would assign 'true' at the index in trackArr.
        2. The idea is to add 0 first, and assign true at index 0 in trackArr.
        3. Run a while Loop:
            1. Pop the element out from queue and print it.
            2. Add its neighbours/adjacent elements in queue. If they are already visited
             no need to add them again in queue.
     */

    public static void breadthFirstTraversalFinal(int[][] adMat, int initialRow, boolean[] trackArr){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(initialRow);
        trackArr[initialRow] = true;

        while (!queue.isEmpty()){
            int elem = queue.poll();
            System.out.print(elem + " ");

            // adding its neighbours/adjacent elements:
            for (int i = 0; i < adMat.length; i++) {
                if (adMat[elem][i] == 1 && trackArr[i] == false){
                    queue.add(i);
//                    visitedArr[i] = true;
                    trackArr[i] = true;
                }
            }

        }

        return;
    }

    /*
        Here, we create a boolean Array, say trackArr, which we'll use to keep a track on what element
        is not yet visited.
        By doing this, we also take care of disconnected graphs.
     */
    public static void breadthFirstTraversal(int[][] adMat, int n){
        // n = number of vertices
        // e = number of edges

        boolean[] trackArr = new boolean[n];
// We would send this trackArr, and the elements which are visited must be marked true.
// Do this in a Loop, and we would be able to keep a track on which element is visited and which is not.
// If the element is visited already, we do not do anything.
// If not, we call on breadthFirstTraversalFinal function.

        for (int i = 0; i < n; i++) {
            if (!trackArr[i]) {
                breadthFirstTraversalFinal(adMat, i, trackArr);
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

        if (n > 0) { // if there are more than 0 vertices.
            breadthFirstTraversal(adMat, n);
        }

    }
}
