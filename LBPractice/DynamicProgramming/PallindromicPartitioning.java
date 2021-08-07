package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class PallindromicPartitioning {
    static int[][] dp;
    static int palindromicPartition(String str)
    {
        // code here
        dp = new int[502][502];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        return MinPartition(str,0,str.length()-1);
    }
    static int MinPartition(String s1,int i,int j){
        if(i>=j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        if(isPallindrome(s1,i,j)){
            return 0;
        }
        for (int k=i;k<=j-1 ;k++ ) {
            int tempans = MinPartition(s1,i,k)+MinPartition(s1,k+1,j)+1;
            min = Math.min(min,tempans);
        }
        return dp[i][j] = min;
    }
    // i and j dek hi krni hai check kyuki subpart check krre hai
    public static boolean isPallindrome(String s1,int i,int j){
        while(i<j){
            if(s1.charAt(i)!=s1.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
