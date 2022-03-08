package Recursion_02;
import java.util.Scanner;

public class check_AB {
    public static boolean check(String str,int i){
        if (i == str.length()){
            return true;
        }
        if(i==0 && str.charAt(0) != 'a')
        {
            return false;
        }
        if(str.charAt(i) == 'a'){
            if(str.length()>i+1){
                return check(str,i+1);
            }
            else {
                return true;
            }
        }
        else if(str.charAt(i) == 'b' && str.length()>i+1){
            if(str.charAt(i+1) == 'b'){
                if(str.length() == i+2){
                    return true;
                }
                if(str.length()>i+2 && str.charAt(i+2) == 'a'){
                    return check(str,i+3);
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return false;
    }

    public static boolean checkAB(String str){
        boolean result;
        result = check(str,0);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        boolean result = checkAB(str);
        System.out.println(result);

    }
}
