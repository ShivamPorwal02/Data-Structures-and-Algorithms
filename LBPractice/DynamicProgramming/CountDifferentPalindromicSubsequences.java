package LoveBabbar.DynamicProgramming;

import java.util.HashMap;

public class CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String s) {

        long[][] dp = new long[s.length()][s.length()];
        int[] prev = new int[s.length()];
        int[] next = new int[s.length()];
        int mod = (int)Math.pow(10, 9) + 7;

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                prev[i] = hm.get(ch);
            }else{
                prev[i] = -1;
            }
            hm.put(ch,i);
        }
        hm.clear();
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                next[i] = hm.get(ch);
            }else{
                next[i] = -1;
            }
            hm.put(ch,i);
        }

        for(int gap =0 ;gap<s.length();gap++){

            for(int i=0,j=gap;j<s.length();i++,j++){
                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1){
                    dp[i][j] = 2;
                }else{
                    if(s.charAt(i)!=s.charAt(j)){
                        dp[i][j] = dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                    }else{
                        int n = next[i];
                        int p = prev[j];

                        if(n>p){
                            dp[i][j] = 2*dp[i+1][j-1]+2;

                        }else if(n==p){
                            dp[i][j] = 2*dp[i+1][j-1]+1;

                        }else{
                            dp[i][j] = 2*dp[i+1][j-1]-dp[n+1][p-1];
                        }
                    }

                    // this is used to deal with overflow errors
                    dp[i][j] = (dp[i][j] < 0 ? dp[i][j] + mod : dp[i][j]) % mod;
                }
            }
        }
        return (int)dp[0][s.length()-1];

    }
}
