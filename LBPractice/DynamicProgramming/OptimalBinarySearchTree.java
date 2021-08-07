package LoveBabbar.DynamicProgramming;

public class OptimalBinarySearchTree {
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int[][] dp = new int[n][n];

        int[] psa = new int[n];
        psa[0] = freq[0];
        for(int i=1;i<n;i++){
            psa[i] = psa[i-1]+freq[i];
        }

        for(int gap = 0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap==0){
                    dp[i][j] = freq[i];
                }else if(gap==1){
                    int freq1 = freq[i];
                    int freq2 = freq[j];
                    dp[i][j] = Math.min(freq1+2*freq2,2*freq1+freq2);
                }else{
                    int fs = psa[j] - (i==0 ? 0 : psa[i-1]);
                    int min = Integer.MAX_VALUE;
                    for(int k=i;k<=j;k++){
                        int left = k==i ? 0 : dp[i][k-1];
                        int right = k==j ? 0 : dp[k+1][j];

                        min = Math.min(min,left+right+fs);

                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n-1];
    }
}
