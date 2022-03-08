package Arrays;

import java.util.Scanner;

public class rotating_Array {




        public static void rotateArray(int[] arr , int D){
            if (D > 0){
                int D_end = D;
                int D_start = D;
                //New Array :
                int a = 0;
                int[] arr_new = new int[D];
                while (a < D_start){
                    arr_new[a] = arr[a];
                    a++;
                }

                int temp;
                int i = 0;
                int j = arr.length-D;
                while (i < j){
                    temp = arr[i];
                    arr[i] = arr[D];
                    arr[D] = temp;
                    i++;
                    D++;
                }
                // System.out.println(i);
                int k = 0;

                while (k < D_end){
                    arr[i] = arr_new[k];
                    k++;
                    i++;
                }
                // end of if loop
            }


            // Printing:
            for (int i1 = 0; i1 < arr.length; i1++){
                System.out.print(arr[i1] + " ");
            }

        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of test cases need to be run: ");
            int cases = sc.nextInt();
            int g = 0;
            while (g < cases){
                System.out.print("Enter the size of array: ");
                int n = sc.nextInt();
                // Creating an array :
                int[] arr = new int[n];
                for (int i = 0; i < n; i++){
                    arr[i] = sc.nextInt();
                }

                System.out.print("Enter D: ");
                int D = sc.nextInt();

                g++;
                rotateArray(arr , D);

            }



        }
    }


