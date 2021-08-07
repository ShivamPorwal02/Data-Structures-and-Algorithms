package DynamicProgrammingandGreedy;
import java.util.*;
import java.util.Scanner;

public class Knapsack01 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for (int i=0;i<n ;i++ ) {
            val[i]=scn.nextInt();
        }
        for (int i=0;i<n ;i++ ) {
            wt[i] = scn.nextInt();
        }
        int totalwt = scn.nextInt();
        int x = maxProfit(wt,val,totalwt,n);
        System.out.println(x);
        int y = DPBottomUP(wt,val,totalwt,n);
        System.out.println(y);
        int z = MemoKnapsack(wt,val,totalwt,n);
        System.out.println(z);
    }

    // RECURSIVE //
    public static int maxProfit(int[] wt,int[] val,int totalwt,int n){
        if(n==0 || totalwt == 0){
            return 0;
        }
        if(wt[n-1]<=totalwt){
            return Math.max(val[n-1]+maxProfit(wt,val,totalwt-wt[n-1],n-1),maxProfit(wt,val,totalwt,n-1));
        }
        else{
            return maxProfit(wt,val,totalwt,n-1);
        }
    }

    // TABULATION //
    public static int DPBottomUP(int[] wt,int[] val,int totalwt,int n){
        int[][] dp = new int[n+1][totalwt+1];

        // base condition ko table m bhrdo kyuki n=0 aur totalwt=0 prr
        for (int i=0;i<dp.length ;i++) {
            for (int j=0;j<dp[0].length ;j++ ) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for (int i=1;i<dp.length ;i++ ) {
            for (int j=1;j<dp[0].length ;j++ ) {
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max((val[i-1]+dp[i-1][j-wt[i-1]]),dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totalwt];
    }

    // MEMORIZATION //

    // static array bnalo constraint dekhk
    static Integer[][] storage = new Integer[21][51];
    public static int MemoKnapsack(int[] wt,int[] val,int totalwt,int n){
        if (n==0 || totalwt == 0) {
            return 0;
        }
        if(storage[n][totalwt]!=null){
            return storage[n-1][totalwt];
        }
        if(wt[n-1]<=totalwt){
            return storage[n][totalwt]=Math.max(val[n-1]+maxProfit(wt,val,totalwt-wt[n-1],n-1),maxProfit(wt,val,totalwt,n-1));
        }
        else{
            return storage[n][totalwt]=maxProfit(wt,val,totalwt,n-1);
        }
    }
}
