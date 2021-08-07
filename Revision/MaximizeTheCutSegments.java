package Revision;

import java.util.Arrays;

public class MaximizeTheCutSegments {
    static int[] dp;
    public int maximizeCuts(int n, int x, int y, int z)
    {
        //Your code here
        dp = new int[100005];
        Arrays.fill(dp,-1);
        int ans = max(n,x,y,z);
        if(ans<0) return 0;
        return ans;

    }
    public int max(int n,int x,int y,int z){
        if(n==0) return 0;

        if(dp[n]!=-1) return dp[n];
        int temp1 = Integer.MIN_VALUE;
        int temp2 = Integer.MIN_VALUE;
        int temp3 = Integer.MIN_VALUE;
        if(n>=x) temp1= max(n-x,x,y,z);
        if(n>=y) temp2= max(n-y,x,y,z);
        if(n>=z) temp3= max(n-z,x,y,z);

        return dp[n]= 1+Math.max(temp1,Math.max(temp2,temp3));
    }
}
