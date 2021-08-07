package LoveBabbar.DynamicProgramming;

public class TargetSum {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==1 && nums[0]!=target && nums[0]!=-target) return 0;
        int sum = 0;
        int zeros = 0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i] == 0) zeros++;
        }
        if(target > sum)
            return 0;
        if((target+sum)%2!=0)
            return 0;
        int sum1 = (sum+target)/2;

        return count(nums,sum1,zeros);
    }
    public int count(int[] nums,int sum,int cnt){
        dp = new int[nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]==0) dp[i][j] = dp[i-1][j];
                else if(j < nums[i-1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
            }
        }
        return (int)Math.pow(2,cnt)*dp[nums.length][sum];
    }
}
