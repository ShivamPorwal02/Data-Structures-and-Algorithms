package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class tiling2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int ans = tiling(n,m);
        System.out.println(ans);
    }
    static int[] dp = new int[101];
    public static int tiling(int n,int m){
        if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        if(n==0){
            return 1;
        }
        return dp[n]=tiling(n-1,m) + tiling(n-m,m);
    }
}
