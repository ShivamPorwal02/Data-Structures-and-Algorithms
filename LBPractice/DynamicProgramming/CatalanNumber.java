package LoveBabbar.DynamicProgramming;

public class CatalanNumber {
    public static int catalanNumber(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int x = 0;
            int y = i-1;
            while(x!=i){
                dp[i]+=(dp[x]*dp[y]);
                x++;
                y--;
            }
        }
        return dp[n];
    }
}
