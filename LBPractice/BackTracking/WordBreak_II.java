package LoveBabbar.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak_II {
    static List<String> lst;
    public List<String> wordBreak(String s, List<String> dict) {
        lst = new ArrayList<>();
        HashSet<String> hm = new HashSet<>();
        for(String str : dict) hm.add(str);
        word(s,"",hm);
        // Collections.sort(lst);
        return lst;
    }
    public static void word(String s,String ans,HashSet<String> hm){
        if(s.length()==0){
            lst.add(ans.substring(0,ans.length()-1));
            // System.out.println(lst);
            return ;
        }
        // System.out.println(s);
        for(int i=0;i<s.length();i++){
            if(hm.contains(s.substring(0,i+1))){
                word(s.substring(i+1),ans+s.substring(0,i+1)+" ",hm);
            }
        }
    }
}
