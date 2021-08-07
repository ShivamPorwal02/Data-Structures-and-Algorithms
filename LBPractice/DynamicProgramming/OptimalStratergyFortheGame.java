package LoveBabbar.DynamicProgramming;

public class OptimalStratergyFortheGame {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        if(nums.length==1) return true;

        for(int gap = 0 ;gap<nums.length;gap++){
            for(int i=0,j=gap;j<nums.length;i++,j++){
                if(gap==0){
                    dp[i][j] = nums[i];
                }else if(gap==1){
                    dp[i][j] = Math.max(nums[j],nums[i]);
                }else{
                    int val1 = nums[i] + Math.min(dp[i+2][j],dp[i+1][j-1]);
                    int val2 = nums[j] + Math.min(dp[i][j-2],dp[i+1][j-1]);
                    dp[i][j] = Math.max(val1,val2);
                }
            }
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];

        return  dp[0][nums.length-1] >= sum-dp[0][nums.length-1];
    }
}
