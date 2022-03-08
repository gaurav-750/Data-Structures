package Arrays;

public  class Sort {

    // Selection sort :-
    public  void selectionSort(int arr[]) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int min = arr[i]; // consider minimum element as arr[i]
            int j = i + 1;
            while (j < n) {
                if (min > arr[j]) { // if we find an element less than min, swap them
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
                j++;
            }
            for (int elem: arr){
                System.out.print(elem + " ");
            }
            System.out.println();
            i++;
        }
    }

        //insertion sort
        public  void insertionSort ( int arr[]){
            int i = 1;
            while (i < arr.length) {
                // insert element in sorted area
                int j = i - 1;
                while (j >= 0) {
                    if (arr[j] > arr[j + 1]) { // swap those elements
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                    j--;
                }
                i++;
            }
        }

                // Bubble Sort-
    public void bubbleSort(int arr[]) {
        int max;
        int biggerLoop = 0;

        while (biggerLoop < arr.length) {
            int i = 0; // 1st Element
            int j = 1; // 2nd Element
            while (i < arr.length && j < arr.length) {
                if (arr[i] > arr[j]) {
                    max = arr[i];
                    arr[i] = arr[j];
                    arr[j] = max;
                }

                for (int value : arr) {
                    System.out.print(value + " ");
                }
                System.out.println();
                i++;
                j++;
            }

            biggerLoop++;
        }
    }

    // Shell Sort:
    public static void shellSort(int[] arr){


    }

}

