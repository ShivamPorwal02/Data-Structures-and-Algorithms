package LoveBabbar.BackTracking;

import java.util.Arrays;

public class CombinationSum4 {
    // DP solution
    public int combinationSum4(int[] arr, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i-arr[j]>=0){
                    dp[i]+=dp[i-arr[j]];
                }
            }
        }
        return dp[target];
    }
    // memo
    static int[] memo;

    public int combinationSum4_(int[] arr, int target) {
        memo = new int[target+1];
        // System.out.println(memo.length);
        Arrays.fill(memo,-1);
        memo[0] = 1;
        return combinationSum(arr,target);
    }
    public int combinationSum(int[] arr,int target){
        int result = 0;
        if(target==0) return 1;
        if(target<0) return 0;
        if(memo[target]!=-1) return memo[target];
        for(int i=0;i<arr.length;i++){
            result+=combinationSum(arr,target-arr[i]);
            memo[target] = result;
        }
        memo[target] = result;
        return result;
    }
}
