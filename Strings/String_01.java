package Strings;

import java.util.Locale;
import java.util.Scanner;

public class String_01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Creating a string:
//        String str = "Gaurav Somani";
//        System.out.println(str);
//
//        // Length of string :
//        System.out.println(str.length());
//
//        // To access a particular character in a string :
//        System.out.println(str.charAt(6));
//
//        // more functions on string :-
//        // Concatenate
       //String str1 = "Coding";
        //ring str2 = " is fun!";
//        System.out.println(str1+str2);
//        System.out.println(str1.concat(str2));
//
//        // Equality
       // System.out.println(str1.equals(str2));
//
//       // System.out.println(str1.compareTo(str2));
//
//        System.out.println(str1.contains("ing"));
//
//        String str3 = "abcd";
//        String str4 = "abcda";
//        System.out.println(str3.compareTo(str4));
//
//
//        String a="coding",b="ninjas";
//        if(a.contains("ing"))
//        {
//            a+=b;
//        }
//        else
//        {
//            b+="ing";
//        }
//        System.out.print(b+a);
//
        // Substring :-

//        String str = "Coding";
//        System.out.println(str.substring(1 , 5));  // End index is exclusive

        // Taking input :-

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a string: ");
//
//        String str = sc.next();
//        System.out.println(str + " " + str.length());
//
//        String str2 = sc.nextLine();
//        System.out.println(str2 + " " + str2.length());




//        String str1 = "Gaurav Somani";
//        for (int i = 0; i < str1.length(); i++){
//            System.out.print(str1.charAt(i) + " ");
//        }


//        String str1 = "gaurav";
//        str1 = str1 + "somani";
//        String str2 = "gaurav";
//      //  System.out.println(str1 == str2);
//        System.out.println(Integer.toHexString(str1.hashCode()));
//        System.out.println(Integer.toHexString(str2.hashCode()));
//
//        String str_1 = new String("Gaurav");
//        String str_2 = new String(str_1 + "S");
//        System.out.println(Integer.toHexString(str_1.hashCode()));
//        System.out.println(Integer.toHexString(str_2.hashCode()));




//
//        String str3 = "abc";
//        String str4 = new String("abc");
//        System.out.println(str3.equals(str4));

//        String str1="abc";
//        String str2=str1+" ";
//        System.out.println(str1==str2);

//        String str1="abc";
//        String str2="";
//        System.out.println(str1.contains(str2));

//
//        String str1 = "gaurav";
//        String str2 = "gaurav";
//
//        System.out.println(str1.contains(str2));

//        String str = "Gaurav";
//        System.out.println(str.substring(0,1));



//       StringBuffer str = new StringBuffer("Gaurav");
////       str.setCharAt(5 , 'A');
////        str.append(" Somani");
////        str.replace(0 , 3 , "Som");
//
//        System.out.println(str);


//        StringBuffer str = new StringBuffer(sc.next());
//        int j = 0;
//        str.replace(j , 1 , "XXX");
//        System.out.println(str);


//        for (int j = 0; j < 5; j++){
//            str.append((char) ('a'+j));
//        }
//        System.out.println(str);


//       String str = "Gaurav";
////       str = str.substring(0,0) + 'X' + str.substring(1);
////        System.out.println(str);
//
//
//        str = str + " " + "Somani" + 1;
//        System.out.println(str);



        // Few Types of operations which can be performed on STRINGS :-
        String str1 = "Gaurav ";
        String str2 = "Somani";
        System.out.println(str1.substring(2)); // returns string from the specified index number
        System.out.println(str1.substring(2,6));
        System.out.println(str1.concat(str2));
        System.out.println(str1.replace('a' , 'x'));
        System.out.println(str1.indexOf('v'));
        System.out.println(str1.indexOf('a' , 2));
        System.out.println(str1.toUpperCase());
        System.out.println(str1.toLowerCase());
    }
}
