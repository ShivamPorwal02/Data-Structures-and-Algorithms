package LoveBabbar.DynamicProgramming;

import java.util.HashMap;

public class DistinctSubsequences {
    int distinctSubsequences(String s) {
        // code here
        long[] dp = new long[s.length()+1];
        int mod = (int)(Math.pow(10,9)+7);
        HashMap<Character,Integer> hm = new HashMap<>();
        dp[0] = 1;

        for(int i=1;i<dp.length;i++){
            char ch = s.charAt(i-1);
            dp[i] = 2*dp[i-1];

            if(hm.containsKey(ch)){
                int j = hm.get(ch);
                dp[i] = dp[i] - dp[j-1];
            }
            hm.put(ch,i);
            dp[i] = (dp[i] < 0 ? dp[i] + mod : dp[i]) % mod;
        }
        return (int)dp[s.length()];
    }
}
