package Linked_List_Recursion_DS;

import java.util.Scanner;

public class dsl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        float n = sc.nextFloat();

        Node<Integer> head = null;

        String str = String.valueOf(n);
        System.out.println(str);

        char lastDigit = str.charAt(str.length()-1);
        System.out.println(lastDigit);

        int i = Integer.parseInt(String.valueOf(lastDigit));
        System.out.println(i-3);


    }
}
