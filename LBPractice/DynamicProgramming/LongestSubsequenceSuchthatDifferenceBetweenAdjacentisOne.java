package LoveBabbar.DynamicProgramming;

public class LongestSubsequenceSuchthatDifferenceBetweenAdjacentisOne {
    static int longestSubsequence(int n, int arr[])
    {
        // code here
        int[] dp = new int[n];
        int omax = 0;

        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(Math.abs(arr[i]-arr[j])==1){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
            if(dp[i]>omax) omax = dp[i];
        }
        return omax;
    }
}
