package HashMaps;

import java.util.*;

public class HashMaps {

    public static int maxFrequencyOfNum(int[] arr){
        if (arr.length == 0){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>(); // creating a new HashMap

        for (int i = 0; i < arr.length; i++) { // building hashmap
            if (map.containsKey(arr[i])){
                int value = map.get(arr[i]);
                value++;
                map.put(arr[i], value);
            }else {
                map.put(arr[i], 1);
            }
        }

//        System.out.println(map);

        int maxKey = arr[0];
        for (int i = 0; i <arr.length; i++){
            if (map.get(maxKey) < map.get(arr[i])){
                maxKey = arr[i];
            }
        }

        /*
        ArrayList<Integer> valueList = new ArrayList<>();
        valueList.addAll(map.values()); // adding all values of map in ArrayList

        Collections.sort(valueList); // sorting the arraylist
//        System.out.println("valueList: " + valueList);
        int maxFrequencyValue = valueList.get(valueList.size()-1); // the maximum number would be at last
//        System.out.println("maxFrequencyValue = " + maxFrequencyValue);

//        System.out.println("keySet: " + map.keySet());
        for (int key: map.keySet()){
            if (map.get(key) == maxFrequencyValue){
                return key;
            }
        }
         */

        return maxKey;
    }

    public static ArrayList<Integer> removeDuplicates(int[] arr){
        ArrayList<Integer> outputList = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>(); // creating hashmap named 'map'

        for (int i = 0; i < arr.length; i++) {
            // check if the key(in our case, element of arr) already exists in our map
            if (map.containsKey(arr[i])){
                continue;
            }

            map.put(arr[i], true);
            outputList.add(arr[i]);
        }
//        System.out.println(map);
        return outputList;
    }
    /*
     Algorithm for printIntersection :
        1. Traverse through arr1, build a hashmap with 'key' as elements, and value as 'frequency'
        of elements.
        2. Traverse through arr2 :
            1. Check whether element already exists in map.
            2. If it exists, check its frequency.
            3. If freq is > 0, print that element and DECREASE ITS FREQUENCY COUNT.
            4. If freq is 0, that means no pairs can be further formed.

     */
    public static void printIntersection(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key: arr1){ // traversing through arr 1, and building hashmap with key and frequency
            if (map.containsKey(key)){
                int value = map.get(key);
                map.put(key, value+1);
            }else {
                map.put(key, 1);
            }
        }

        for (int elem : arr2) {
            if (map.containsKey(elem)) {
                int freq = map.get(elem);
                if (freq > 0) {
                    System.out.print(elem + " ");
                    map.put(elem, freq - 1);
                }
            }

        }

        return;
    }

    public static int pairSumTo0(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();

        // building a hashmap of positive numbers (including zero)
        for (int key : arr) {
            if (key >= 0) {
                if (map.containsKey(key)){
                    int value = map.get(key);
                    map.put(key, value + 1);
                }else {
                    map.put(key, 1);
                }
            }
        }
        System.out.println(map);

        /*
        1. For every negative number, checking whether map contains positive of that number.
        2. Then finding its value.
        3. if value is for eg.2, that means that element exists 2 times in array, and hence that many
        number of pairs can be generated (with its negative counterpart).
         */
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0){ // negative number
                if (map.containsKey(-arr[i])){
                    int value = map.get(-arr[i]);
                    count = count+value;
//                    System.out.println("(" + arr[i] + "," + -arr[i] + ")");
                }
            }
        }

        // numbers of pairs which '0' itself can make(if it is present more than 1 times) -
        if(map.containsKey(0)){
            int value = map.get(0);
            int numPairsZero = 0;
            for (int j = 1; j < value; j++) {
                numPairsZero = numPairsZero+j;
            }
            count = count+ numPairsZero;
        }

        return count;
    }
    public static int pairSumToZero(int[] arr){
        HashMap<Integer, Integer>  map = new HashMap<>();

        for (int key: arr){ // building HashMap
            if (map.containsKey(key)){
                int value = map.get(key);
                map.put(key, value+1);
            }else {
                map.put(key, 1);
            }
        }
//        System.out.println(map);

        int countPairs = 0;
        for (int elem: arr){
            if (map.containsKey(-elem) && elem != 0){
                int pValue = map.get(elem);
                int nValue = map.get(-elem);
                countPairs = countPairs + (pValue*nValue);

                map.put(elem, 0);
                map.put(-elem, 0);
            }
        }
        // numbers of pairs which '0' itself can make(if it is present more than 1 times) -
        if(map.containsKey(0)){
            int value = map.get(0);
            int numPairsZero = 0;
            for (int j = 1; j < value; j++) {
                numPairsZero = numPairsZero+j;
            }
            countPairs = countPairs+ numPairsZero;
        }

        return countPairs;
    }

    public static String uniqueCharacters(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        String strAns = "";
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))){
                continue;
            }else {
                map.put(str.charAt(i), 1);
                strAns = strAns + str.charAt(i);
            }
        }

        return strAns;
    }

    public static void insertionSort(int arr[]){
        int i = 1;
        while (i < arr.length){
            // insert element in sorted area
            int j = i-1;
            while(j >= 0){
                if (arr[j] > arr[j+1]){ // swap those elements
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
                j--;
            }
            i++;
        }

    }

    public static ArrayList<Integer> largestConsecutiveSequence(int[] arr){
        ArrayList<Integer> origArrList = new ArrayList<>(); // original array stored in ArrayList
        for (int i = 0; i < arr.length; i++) {
            origArrList.add(arr[i]);
        }

        insertionSort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>(); // list to be returned

        /*
            we'll build the map, with 'key' with the numbers in array and 'value' with the
        numbers of consecutive numbers ahead of key.
         */
        for (int i = 0; i < arr.length; i++) { // building map
            int consecutiveCount = 0;

            int k = i;
            int j = i+1;
            while (j < arr.length && arr[j]-arr[k] == 1){
                consecutiveCount++;
                j++;
                k++;
            }
            map.put(arr[i], consecutiveCount);
        }
//        System.out.println(map);

        int maxValue = -1;
        int keyIndex = 0;
        int leastKeyIndex = arr.length-1;

        // Now we find the maximum Value in map
        for (int key: map.keySet()){
           if (map.get(key) > maxValue){
               maxValue = map.get(key);
               // Finding the index of the key in original arr
               leastKeyIndex = origArrList.indexOf(key);
               keyIndex = leastKeyIndex;
           }else if (map.get(key) == maxValue){
               keyIndex = origArrList.indexOf(key);
               if (keyIndex < leastKeyIndex){
                   leastKeyIndex = keyIndex;
               }
           }

        }

        list.add(origArrList.get(leastKeyIndex));
        if (maxValue != 0) {
            list.add(origArrList.get(leastKeyIndex) + maxValue);
        }
//        System.out.println(list);
        return list;
    }

    /*
        1.Sort the given array
        2. Now we need to build a "hashmap" with 'key' as the element in array
        and 'value' as the number of total elements with difference k with the key.
        3. Return the total count of all 'values' in the map
     */
    public static int pairsWithDifferenceK(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int countPairs = 0;
        insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            int j = i+1;
            while (j < arr.length){
                if (arr[j] - arr[i] == k){
                    if (map.containsKey(arr[j])){
                        int value = map.get(arr[j]);
                        map.put(arr[j], value+1);
                    }else {
                        map.put(arr[j], 1);
                    }
                    countPairs++;
                }
                j++;
            }
        }
//        System.out.println(map);

        return countPairs;
    }

    public static int longestSubsetZero(int[] arr){
                    // Approach 01

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        while (i < arr.length){
            int j = i+1;
            int sumZero = arr[i];
            int initialCount = 1;
            int count = 1;
            while (j < arr.length){
                sumZero = sumZero+arr[j];
                j++;
                count++;
                if (sumZero == 0){
                    initialCount = count;
                }
            }
            list.add(initialCount);
            i++;
        }
//        System.out.println(list);

        return Collections.max(list);
        }


                    // Approach 02
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int i = 0;
//        int maxLength = 0;
//        int sumTillNow = 0;
//
//        while (i < arr.length){
//            sumTillNow = sumTillNow+arr[i];
//            if (map.containsKey(arr[i])){
//                int value = map.get(arr[i]);
//                if (maxLength < value){
//
//                }
//            }else {
//                map.put(sumTillNow, i);
//            }
//
//            i++;
//        }
//
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                    // Problem 01: Maximum Frequency Number
        // Date: 11-10-2021

        /*
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        int[] arr = {2,12,2,11,12,2,1,2,2,11,12,2,6};
        System.out.println(maxFrequencyOfNum(arr));
         */

                    // Problem 02: Remove Duplicates
        // Date: 11-10-2021

        /*
        int[] arr = {1,3,2,2,3,1,6,2,5};
        ArrayList<Integer> list = removeDuplicates(arr);
        System.out.println(list);
         */

                    // Problem 03: Print Intersection
        // Date: 11-10-2021
        // 23:16
        /*
        System.out.print("Enter the size of Array 1: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of Array 2: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        printIntersection(arr1, arr2);
         */

                     // Problem no.04 : Pair Sum to 0
        // Date: 12-10-2021
        // 18:47
        /*
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        System.out.println("Count: " + pairSumTo0(arr));
        System.out.println("Count: " + pairSumToZero(arr));
         */

                    // Problem no.5 : Extract Unique Characters
        // Date: 14-10-2021
        // 22:36
        /*
        System.out.print("Enter a String: ");
        String str = sc.next();

        System.out.println(uniqueCharacters(str));
         */
                    // Problem no.6 : Largest Consecutive Sequence
        // Date: 14-10-2021
        // 22:36
        /*
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        largestConsecutiveSequence(arr);
         */

                    // Problem no.7 : Pairs with difference k
        // Date: 15-10-2021
        // 10:02

        /*
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Number of Pairs with difference k: " + pairsWithDifferenceK(arr, k));
         */

                    // Problem no.08 : Longest Subset Sum Zero
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(longestSubsetZero(arr));


    }
}
