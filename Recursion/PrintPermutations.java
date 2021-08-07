package Recursion;

import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        printPermutations(s,"");
    }
    public static void printPermutations(String s,String ans) {
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i=0;i<s.length();i++ ) {
            printPermutations(s.substring(0,i)+s.substring(i+1,s.length()),ans+s.charAt(i));
        }
    }
}
