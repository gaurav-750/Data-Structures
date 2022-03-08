package Arrays;

public class Arrays_with_functions_02 {
    public static void incrementArray(int arr[]){
        int i = 0;
        while (i < arr.length){
            arr[i] = arr[i] + 1;
            i++;
        }
    }
    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        incrementArray(arr);
        printArray(arr);

    }
}
