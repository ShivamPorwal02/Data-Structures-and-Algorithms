package LoveBabbar.DynamicProgramming;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        int omax = 0;
        for(int i=0;i<arr.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
            if(dp[i]>omax){
                omax = dp[i];
            }
        }
        return omax;
    }
}
