package Recursion_02;

public class Return_Permutations_Of_String {

    public static String[] permutationsOfString(String str){
        // base case
        if (str.length() == 1){
            String[] strArr = new String[1];
            strArr[0] = str;
            return strArr;
        }

        String[] sArr = permutationsOfString(str.substring(1));

        String[] output = new String[sArr.length * str.length()];
        // Now by this loop, we add the str.charAt(0) to front, back and between
        int k = 0;
//        for (int i = 0; i < str.length(); i++) {
//            for (String s: sArr){
//                output[k] = s.substring(0,i) + str.charAt(0) + s.substring(i);
//                k++;
//            }
//
//        }

        // (or)
        for (String s: sArr){
            for (int i = 0; i < str.length(); i++) {
                output[k] = s.substring(0,i) + str.charAt(0) + s.substring(i);
                k++;
            }
        }
        return output;
    }

    public static void printPermutationsOfString(String str, String outputSoFar){
        // base case
        if (str.length() == 0){
            System.out.println(outputSoFar);
            return;
        }

        int i = 0;
        while (i < str.length()){
            String outputNew = outputSoFar+str.charAt(i);
            String strNew = str.substring(0, i) + str.substring(i+1);
//            System.out.println("strNew = " + strNew);

            printPermutationsOfString(strNew, outputNew);
            i++;
        }

        return;
    }

    public static void printPermutationsOfString(String str){
        String outputSoFar = "";
        printPermutationsOfString(str, outputSoFar);
    }

    public static void main(String[] args) {

        String[] ans = permutationsOfString("abc");
        int count = 0;
        for (String s: ans){
            System.out.println(s);
            count++;
        }
//        System.out.println(count);

        printPermutationsOfString("abc");

    }
}
