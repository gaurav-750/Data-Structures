package Recursion_02;
import java.util.HashMap;
import java.util.Scanner;

// Date: 23-10-2021
public class Return_KeyPad {

    public static String keypadCombination(int n){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        return map.get(n);
    }

    public static String[] returnKeyPad(int n){
        // base case
        if (n == 0){
            String[] strArr = {""};
            return strArr;
        }

        String[] smallAns = returnKeyPad(n/10);
        String str = keypadCombination(n%10);

        String[] output = new String[str.length()* smallAns.length];
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            for (String s: smallAns) {
                output[k]  = s+str.charAt(i);
                k++;
            }
        }

        return output;
    }

    public static void printKeyPadCombinations(int n, String outputSoFar){
        // base case
        if (n == 0){
            System.out.println(outputSoFar);
            return;
        }

        String str = keypadCombination(n%10);
        for (int i = 0; i < str.length(); i++) {
            printKeyPadCombinations(n/10, str.charAt(i)+outputSoFar);
        }

        return;
    }
    /*
        1. Here what we r doing is, we already are sending an empty String with our function.
        2. In our function we call on the smaller part of the integer, along with the other options
        one by one
        3. Once it reaches the base case, we just print the Output.
     */
    public static void printKeyPadCombinations(int n){
        printKeyPadCombinations(n, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();


        String[] ans = returnKeyPad(n);
        for (String s: ans){
            System.out.println(s);
        }

        printKeyPadCombinations(n);
    }
}
/*
Question:
    Given an integer n,
    using phone keypad find out all the possible strings that can be made using digits of input n.
    Return an empty string if n is 0.
 */