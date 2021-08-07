package LoveBabbar.DynamicProgramming;

import java.util.ArrayList;

public class AllPalindromicPartitioning {
    static ArrayList<ArrayList<String>> lst;
    public ArrayList<ArrayList<String>> partition(String s) {
        lst = new ArrayList<>();
        partitionHelper(s,new ArrayList<>());
        return lst;
    }
    private void partitionHelper(String ques,ArrayList<String> ans){
        if(ques.length()==0){
            lst.add(new ArrayList<>(ans));
            return;
        }

        for(int i=0;i<ques.length();i++){
            String prefix=ques.substring(0,i+1);
            if(ispalindrome(prefix)){
                String ros=ques.substring(i+1); //ros: rest of string
                ans.add(prefix);
                partitionHelper(ros,ans);
                ans.remove(ans.size()-1);
            }
        }

    }
    public boolean ispalindrome(String s){
        int i=0;
        int j = s.length()-1;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
