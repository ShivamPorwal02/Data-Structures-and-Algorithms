package LeetCode;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return nums[1]>nums[0] ? nums[1] : nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1]>nums[0] ? nums[1] : nums[0];

        int max = nums[1]>nums[0] ? nums[1] : nums[0];
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max==Integer.MIN_VALUE ? 0 : max;
    }
}
