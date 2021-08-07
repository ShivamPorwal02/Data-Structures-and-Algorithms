package Recursion;

import java.util.Scanner;

public class PrintSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        printSS(s,"");
    }
    public static void printSS(String str,String ans) {
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        str = str.substring(1);
        printSS(str,ans+"");
        printSS(str,ans+ch);
        return;
    }
}
