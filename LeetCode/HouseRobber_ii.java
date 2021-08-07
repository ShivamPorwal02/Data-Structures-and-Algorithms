package LeetCode;

public class HouseRobber_ii {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return nums[1]>nums[0] ? nums[1] : nums[0];
        return Math.max(rob0(nums),rob1(nums));
    }
    public int rob0(int[] nums){
        int[] dp = new int[nums.length-1];
        dp[0] = nums[0];
        dp[1] = nums[1]>nums[0] ? nums[1] : nums[0];
        for(int i=2;i<nums.length-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-2];
    }
    public int rob1(int[] nums){
        int[] dp = new int[nums.length-1];
        dp[0] = nums[1];
        dp[1] = nums[2]>nums[1] ? nums[2]: nums[1];
        for(int i=2;i<nums.length-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i+1]);
        }
        return dp[nums.length-2];
    }
}
