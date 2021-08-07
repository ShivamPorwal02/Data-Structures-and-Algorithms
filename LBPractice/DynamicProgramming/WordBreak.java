package LoveBabbar.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak {
    public static int wordBreak(String s, ArrayList<String> B )
    {
        //code here
        HashSet<String> hs = new HashSet<>();
        for(String s1 : B){
            hs.add(s1);
        }
        int[] dp = new int[s.length()];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                String w2break = s.substring(j,i+1);
                if(hs.contains(w2break)){
                    if(j>0){
                        dp[i]+=dp[j-1];
                    }else{
                        dp[i] = 1;
                    }
                }
            }
        }
        return dp[s.length()-1]>0 ? 1 : 0;

    }
}
