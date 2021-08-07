package LoveBabbar.DynamicProgramming;

public class MinimumNumberofRemovalstoMakeMountainArray {
    public int minimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
        }

        int[] dp1 = new int[n];
        for(int i=n-1;i>=0;i--){
            int max = 0;
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j]){
                    if(dp1[j]>max){
                        max = dp1[j];
                    }
                }
            }
            dp1[i] = max+1;
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(dp[i]>1 && dp1[i]>1) // if element nums[i] is a valid peak,
                max=Math.max(max,dp1[i]+dp[i]-1);
        }
        return arr.length-max;
    }
}
