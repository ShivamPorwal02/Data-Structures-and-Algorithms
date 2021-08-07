package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        ArrayList<String> ans = gss(s);
        System.out.println(ans);
    }
    public static ArrayList<String> gss(String s){
        if(s.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char c = s.charAt(0);
        s=s.substring(1);
        ArrayList<String> rres = gss(s);
        ArrayList<String> mres = new ArrayList<>();
        for(String sstr : rres){
            mres.add(""+sstr);
        }
        for(String sstr : rres){
            mres.add(c+sstr);
        }
        return mres;
    }
}
