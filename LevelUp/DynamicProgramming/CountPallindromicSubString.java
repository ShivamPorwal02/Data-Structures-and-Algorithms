package LevelUp.DynamicProgramming;

import java.util.Scanner;

public class CountPallindromicSubString {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int cnt = 0;
        for(int gap =0;gap<s.length();gap++){
            for(int i=0,j=gap;j<s.length();i++,j++){
                if(gap==0){
                    dp[i][j] = true;
                }else if(gap==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j]){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

}
