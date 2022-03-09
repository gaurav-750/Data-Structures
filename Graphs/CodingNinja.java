package Graphs;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Scanner;

public class CodingNinja {

    public static boolean solveCodingNinja(char[][] mat, int i, int j, boolean[][] visitedArr, String str, int charNum){
//        System.out.println(str + " " + charNum + " " + str.charAt(charNum));
//        System.out.println(i + " " + j);
        // base case
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || visitedArr[i][j] || mat[i][j] == 'X'){
            return false;
        }
        if (charNum == str.length()-1){ // we have reached till 'A', i.e the last alphabet in CODINGNINJA
            return mat[i][j] == str.charAt(charNum);
        }

        if (mat[i][j] == str.charAt(charNum)){ // if the character is found
            visitedArr[i][j] = true;
            charNum++;
        }else{
            return false;
        }

        // north
        boolean o1 = solveCodingNinja(mat, i-1, j, visitedArr, str, charNum);
        if (o1){ // if 01 is true, return true
            return true;
        }
        if ((i-1) >= 0) {
            visitedArr[i - 1][j] = false;
        }

        // north-east
        boolean o2 = solveCodingNinja(mat, i-1, j+1, visitedArr, str, charNum);
        if (o2){
            return true;
        }
        if ((i-1) >= 0 && (j+1) < mat[0].length) {
            visitedArr[i - 1][j + 1] = false;
        }

        // east
        boolean o3 =solveCodingNinja(mat, i, j+1, visitedArr, str, charNum);
        if (o3){
            return true;
        }
        if ((j+1) < mat[0].length) {
            visitedArr[i][j + 1] = false;
        }

        // south-east
        boolean o4 = solveCodingNinja(mat, i+1, j+1, visitedArr, str, charNum);
        if (o4){
            return true;
        }
        if ((i+1) < mat.length && (j+1) < mat[0].length) {
            visitedArr[i + 1][j + 1] = false;
        }

        // south
        boolean o5 = solveCodingNinja(mat, i+1, j, visitedArr, str, charNum);
        if (o5){
            return true;
        }
        if ((i+1) < mat.length) {
            visitedArr[i + 1][j] = false;
        }

        // south-west
        boolean o6 = solveCodingNinja(mat, i+1, j-1, visitedArr, str, charNum);
        if (o6){
            return true;
        }
        if ((i+1) < mat.length && (j+1) < mat[0].length) {
            visitedArr[i + 1][j + 1] = false;
        }

        // west
        boolean o7 = solveCodingNinja(mat, i, j-1, visitedArr, str, charNum);
        if (o7){
            return true;
        }
        if ((j-1) >= 0) {
            visitedArr[i][j - 1] = false;
        }

        // north-west
        boolean o8 = solveCodingNinja(mat, i-1, j-1, visitedArr, str, charNum);
        if (o8){
            return true;
        }
        if ((i-1) >= 0 && (j-1) >= 0) {
            visitedArr[i - 1][j - 1] = false;
        }

        return false;
    }

    public static int solveCN(char[][] mat, int row, int column){
        boolean[][] trackArr = new boolean[row][column];
        boolean output = false;

        while (!output){
            boolean[][] visitedArr = new boolean[row][column];
            int i = -1, j = -1;

            // find the occurrence of 'C' in mat
            for (int k = 0; k < row; k++) {
                for (int l = 0; l < column; l++) {
                    if (mat[k][l] == 'C' && !trackArr[k][l]){
                        i = k;
                        j = l;
                        trackArr[k][l] = true;
                        break;
                    }
                }
            }
            // if C is not present in mat, that means i and j would still remain -1 and -1
            if (i == -1 && j == -1){
                return 0;
            }

            String str = "CODINGNINJA";// word to be found
//            System.out.println("i: " + i + " " + "j: " + j);
            output = solveCodingNinja(mat, i, j, visitedArr, str, 0);
//            System.out.println("output = " + output);

            for (int k = 0; k < row; k++) {
                for (int l = 0; l < column; l++) {
                    if (visitedArr[k][l]){
                        System.out.print("T ");
                    }else {
                        System.out.print("F ");
                    }
                }
                System.out.println();
            }
            if (i == row-1 && j == column-1){ //for the last index
                if (!output) {
                    return 0;
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int column = sc.nextInt();

        char[][] mat = new char[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println(solveCN(mat, row, column));
    }
}
