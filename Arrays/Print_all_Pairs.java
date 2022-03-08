package Arrays;

public class Print_all_Pairs {
    public static void printAllPairs(int arr[]){
        int i = 0;
        while (i < arr.length){
            int j = (i+1);
            while (j < arr.length){
                System.out.print("(" + arr[i] + "," + arr[j] + ")" + " ");
                j++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        printAllPairs(arr);
    }
}
