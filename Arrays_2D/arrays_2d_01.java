package Arrays_2D;
import java.util.Scanner;

public class arrays_2d_01 {
//    public static void  fun(int[][] arr2d)
//    {
//
//        for(int i=0;i<arr2d.length;i++)
//        {
//            for(int j=0;j<arr2d[i].length;j++)
//            {
//                arr2d[i][j]=2*i+j;
//            }
//        }
//    }
    public static void main(String[] args) {
//        int[][] arr2d = new int[3][4];
//        System.out.println(arr2d);
//
//        //Taking input in a 2D Array :-
//
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter no of rows: ");
//        int r = sc.nextInt();
//        System.out.print("Enter no of columns: ");
//        int c = sc.nextInt();
//////
//////        // Initialising array :
//        int[][] arr2d = new int[r][c];
//////
//////        // Taking input from user :
//        int i = 0;
//        while (i < r){
//            int j = 0;
//            while (j < c){
//                arr2d[i][j] = sc.nextInt();
//                j++;
//            }
//            i++;
//        }
//////
//        // Printing a 2-D Array :
//        for (int row = 0; row < r; row++) {
//            for (int column = 0; column < c; column++) {
//                System.out.print(arr2d[row][column] + " ");
//            }
//            System.out.println();
//        }
//
        /*
        int[][] arr2D = {{1,2,3,4} , {5,6,7,8} , {9,10,11,12} , {1,1,1,1,1}};
        System.out.println(arr2D);
        System.out.println(arr2D[0]);
        System.out.println(arr2D[1]);
        System.out.println(arr2D[2]);

        System.out.println(arr2D.length);
         */


        int[][] arr = new int[2][2];

        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                System.out.print(arr[i][j]+" " );
            }
            System.out.println();
        }

//        int[][] arr2d = new int[4][];
//        System.out.println(arr2d.length);

        int[][] arr2D = new int[5][5];
        arr2D = new int[][] {{1, 2, 3, 4, 10}, {5, 6, 7, 8}, {9, 10, 11, 12, 13}, {1, 1, 1, 1, 1}};

        for (int[] row: arr2D){
            for (int elem : row){
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < arr2D[row].length; col++) {
                System.out.print(arr2D[row][col] + " ");
            }
            System.out.println();
        }



    }
}
