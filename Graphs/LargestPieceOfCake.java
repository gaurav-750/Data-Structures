package Graphs;
import java.util.Scanner;

public class LargestPieceOfCake {

    public static int largestPiece(int[][] adMat, int i, int j, boolean[][] visitedArr){
        System.out.println(i + " " + j);
        // base case
        if (i < 0 || j < 0 || i >= adMat.length || j >= adMat.length || adMat[i][j] == 0 || visitedArr[i][j]){
            return 0;
        }
        visitedArr[i][j] = true;

        // up
        int o1 = largestPiece(adMat, i-1, j, visitedArr);

        // right
        int o2 = largestPiece(adMat, i, j+1, visitedArr);

        // down
        int o3 = largestPiece(adMat, i+1, j, visitedArr);

        // left
        int o4 = largestPiece(adMat, i, j-1, visitedArr);


        int countLargest = o1+o2+o3+o4;
        return countLargest+1;
    }

    public static int largestPieceOfCake(int[][] adMat, int n){

        boolean[][] visitedArr = new boolean[n][n];
        int maxCount = -1;

        while (true){
            int i = -1, j = -1;
            boolean found1 = false;

            // we need to find the position of 1 in matrix
            for (int k = 0; k < adMat.length; k++) {
                int l;
                for (l = 0; l < adMat.length; l++) {
//                    System.out.println(k + " " + l);
                    if (adMat[k][l] == 1 && !visitedArr[k][l]){
                        i = k;
                        j = l;
                        found1 = true;
                        break;
                    }
                }
                if (found1){
                    break;
                }
            }

            // if we haven't found a 1, means i and j will remain -1 and -1.
            if (i == -1 && j == -1){
                return 0;
            }

            System.out.println("i = " + i + " " + "j = " + j);
            int count = largestPiece(adMat, i, j, visitedArr);
            if (count > maxCount){
                maxCount = count;
            }
            System.out.println("maxCount = " + maxCount);

            // checking whether we have traversed completely in the matrix
            boolean traversedCompletely = true;
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    if (adMat[k][l] == 1 && !visitedArr[k][l]) {
                        traversedCompletely = false;
                        break;
                    }
                }
            }

            // if we have traversed completely, just return maxCount.
            if (traversedCompletely){
                System.out.println("TC!");
                return maxCount;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        int[][] adMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adMat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Largest Piece of Cake: " + largestPieceOfCake(adMat, n));
    }

}
