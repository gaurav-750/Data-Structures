package Arrays_2D;

import java.util.Scanner;

public class Arrays2D_with_functions {
    // Printing 2D Array :-
    public static void printArray(int[][] arr2d){
        int r = arr2d.length;
        int c = arr2d[0].length;

        for (int i1 = 0; i1 < r; i1++){
            for (int j1 = 0; j1 < c; j1++){
                System.out.print(arr2d[i1][j1] + " ");
            }
            System.out.println();
        }

    }
    // Taking Input from user :-
    public static int[][] takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter no of columns: ");
        int c = sc.nextInt();

        // Initialising array :
        int[][] arr2d = new int[r][c];

        int i = 0;
        while (i < r){
            int j = 0;
            while (j < c){
                arr2d[i][j] = sc.nextInt();
                j++;
            }
            i++;
        }
        return arr2d;
    }

    public static void main(String[] args) {

        int[][] input = takeInput();
        printArray(input);

    }
}
