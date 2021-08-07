package LoveBabbar.Strings;

import java.util.Scanner;

public class AllSubsequence {
    public static void subsequence(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        s = s.substring(1);
        subsequence(s,ans+ch);
        subsequence(s,ans+"");
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        subsequence(s,"");
    }
}
