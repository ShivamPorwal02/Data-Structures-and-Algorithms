package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class EggDroping {
    static int[][] dp;
    public int superEggDrop(int e, int f) {
//        https://leetcode.com/problems/super-egg-drop/discuss/159055/Java-DP-solution-from-O(KN2)-to-O(KNlogN)

        dp = new int[e+1][f+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return eggdrop(e,f);
    }

    public static int eggdrop(int e,int f){

        if(e==1){
            return f;
        }
        if(f==0 || f==1){
            return f;
        }
        if(dp[e][f]!=-1){
            return dp[e][f];
        }
        int min = Integer.MAX_VALUE;
        int low = 1;
        int high = f;
        while(low<high){
            int mid = (low+high)/2;
            int left = eggdrop(e-1,mid-1);
            int right = eggdrop(e,f-mid);
            int temp = 1 + Math.max(left,right);
            min = Math.min(temp,min);
            if(left==right) break;
            else if(left<right) low = mid+1; // kyuki hm worst nikaal rhe hai to jaise right bda hai to hm ussi side jaaenge bda dhundne k lia not sure though
            else high = mid;
        }
        return dp[e][f] =min;
    }
}
