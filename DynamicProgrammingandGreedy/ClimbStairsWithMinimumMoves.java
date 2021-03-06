package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class ClimbStairsWithMinimumMoves {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<a.length ;i++ ) {
            a[i]=scn.nextInt();
        }
        Integer[] dp = new Integer[n+1];
        dp[n]=0;
        //10 se 10 moves 0 hai(chlo hi mtt) aur rasta 1 hai
        for (int i=n-1;i>=0 ;i-- ) {
            if(a[i]>0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= a[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if(min!=Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println(dp[0]);

    }
}
