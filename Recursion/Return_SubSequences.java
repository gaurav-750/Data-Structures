package Recursion_02;
import java.util.Scanner;

// Date: 23-10-2021
// 10:25
public class Return_SubSequences {

    public static String[] returnSubSequences(String str){
        // base case
        if (str.length() == 0){ // if the string is empty, just return an empty String array
            String[] strArr = {""};
            return strArr;
        }

        // call on str.subString(1) (calling on smaller portion of the string):
        String[] smallAns = returnSubSequences(str.substring(1));

        String[] outputArr = new String[2* smallAns.length];
        for (int i = 0; i < smallAns.length; i++) {// copy everything from smallAns Array
            outputArr[i] = smallAns[i];
        }

        // Now, append the first character of string to every string in smallAns array:
        for (int i = 0; i < smallAns.length; i++) {
            outputArr[i + smallAns.length] = str.charAt(0) + smallAns[i];
        }
        return outputArr;
    }

    public static void printSubSequences(String str, String outputSoFar){
        // base case
        if (str.length() == 0){
            System.out.println(outputSoFar);
            return;
        }

        // we choose not to include the first character
        printSubSequences(str.substring(1), outputSoFar);
        // we choose to INCLUDE the first character
        printSubSequences(str.substring(1), outputSoFar+str.charAt(0));

        return;
    }
    /*
        The approach for this problem is as follows:

        1. Assume we have a string - "z".
        2. If we want to print the subsequences of our string, that would be - {"","z"}
        3. So firstly, we call on the smaller part along with the empty string (outputSoFar)
        and then we call on the smaller part along with the "z", the fist character in str (outputSoFar).
        4. Our base case : If str is empty -> just print outputSoFar.
     */
    public static void printSubSequences(String str){
        printSubSequences(str, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();

        String[] ans = returnSubSequences(str);
        for (String s: ans){
            System.out.println(s);
        }

        // Printing all the subSequences
        printSubSequences(str);

    }
}
/*
    SUBSEQUENCES OF A STRING:
        If a given string is "xyz", then its subsequences would be:
        {"", x, y, z, xy, xz, yz, xyz}
 */