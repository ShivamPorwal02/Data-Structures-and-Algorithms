package LevelUp.DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class CountDistinctSubsequences {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.next();

        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=1;i<s.length()+1;i++){
            dp[i] = 2*dp[i-1];
            char ch = s.charAt(i-1);
            if(hm.containsKey(ch)){
                int j = hm.get(ch);
                dp[i] = dp[i] - dp[j-1];
            }
            hm.put(ch,i);
        }
        System.out.println(dp[s.length()]-1);

    }
}
