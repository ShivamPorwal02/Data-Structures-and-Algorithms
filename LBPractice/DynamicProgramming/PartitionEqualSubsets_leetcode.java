package LoveBabbar.DynamicProgramming;

public class PartitionEqualSubsets_leetcode {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0 ;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;

        int sum1 = sum/2;
        int n = nums.length;
        return equalSumPartition(nums,n,sum1);
    }
    boolean[][] dp ;
    public boolean equalSumPartition(int[] nums,int n,int sum){
        dp = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
