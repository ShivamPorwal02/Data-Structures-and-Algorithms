package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintKPC {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        printKPC(s,"");

    }
    static String[] kp = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKPC(String s,String ans) {
        if(s.length()==0) {
            System.out.println(ans);
            return;
        }
        char a = s.charAt(0);
        s=s.substring(1);
        String ss = kp[a - '0'];
        for (int i = 0; i < ss.length(); i++) {
            char d = ss.charAt(i);
            printKPC(s,ans+d);
        }

    }
}
