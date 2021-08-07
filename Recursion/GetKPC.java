package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKPC {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        ArrayList<String> ans = getKPC(s);
        System.out.println(ans);
    }
    static String[] kp = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};  // global array
    public static ArrayList<String> getKPC(String s){
        if(s.length()==0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        // jbb bhi tumhe '6' ko int wala 6 bnana ho to '6'-'0'  krdo isse 6 aajaega actually kisi bhi number ko usk int m bdlna ho to
        // yhi krte hai
        char a = s.charAt(0);
        s=s.substring(1);
        ArrayList<String> rres= getKPC(s);
        ArrayList<String> mres = new ArrayList<>();
        String ss = kp[a-'0'];
        for(int i= 0;i<ss.length();i++){
            char d = ss.charAt(i);
            for(String str : rres){
                mres.add(d+str);
            }
        }
        return mres;
    }
}
