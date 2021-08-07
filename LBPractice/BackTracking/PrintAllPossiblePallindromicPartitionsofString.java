package LoveBabbar.BackTracking;

import java.util.ArrayList;

public class PrintAllPossiblePallindromicPartitionsofString {
    static ArrayList<ArrayList<String>> lst;
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        lst = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        partitions(S,"");
        return lst;
    }
    static void partitions(String s,String ans){
        if(s.length()==0){
            ArrayList<String> lst1 = new ArrayList<>();
            lst1.add(ans);
            lst.add(lst1);
            return;
        }

        for(int i=0;i<s.length();i++){
            if(isPallindrome(s.substring(0,i+1))){
                partitions(s.substring(i+1),ans+s.substring(0,i+1)+" ");
            }
        }
    }
    public static boolean isPallindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
