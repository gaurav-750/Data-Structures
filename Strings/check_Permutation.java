package Strings;
import java.util.Scanner;

public class check_Permutation {
    // BY USING STRING :-

    public static boolean checkPer(String str1 , String str2){
        int i = 0;
        boolean ans = false;
        int true_Counter = 0;
        while (i < str1.length()){
            int j = 0;
            while (j < str2.length()){
                if (str1.charAt(i) == str2.charAt(j)){
                    str2 =  str2.substring(0 , j) + 'X' + str2.substring(j+1);
                    System.out.println(str2);
                    true_Counter++;
                    System.out.println(true_Counter);
                    break;
                }
                j++;
            }
            i++;
        }

        return true_Counter == str1.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String str1 = sc.next();

        System.out.print("Enter string 2: ");
        String str2 = sc.next();

        boolean result = checkPer(str1 , str2);
        System.out.println(result);


    }
}

            // BY USING STRING BUFFER :-

//    public static boolean checkPer(StringBuffer str1 , StringBuffer str2){
//        int i = 0;
//        int true_counter = 0;
//        boolean ans = false;
//        while (i < str1.length()){
//            int j = 0;
//            while (j < str2.length()){
//                if (str1.charAt(i) == str2.charAt(j)){
//                    str2.replace(j , j+1 , "X");
//                    ans = true;
//                    true_counter++;
//                    break;
//                    }
//                j++;
//            }
//            i++;
//        }
//
//        return true_counter == str1.length();
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // Input for string 1
//        System.out.print("Enter string 1: ");
//        StringBuffer str1 = new StringBuffer(sc.next());
//        // Input for string 2
//        System.out.print("Enter string 2: ");
//        StringBuffer str2 = new StringBuffer(sc.next());
//
//        boolean result = checkPer(str1 ,str2);
//        System.out.println(result);
//
//
//
//    }

