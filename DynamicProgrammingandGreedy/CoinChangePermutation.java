package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class CoinChangePermutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a =new int[n];
        for (int i=0;i<n;i++){
            a[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        int[] dp = new int[n];
        dp[0]=1;
        for (int i=1;i<dp.length ;i++ ) {
            for (int j=0;j<a.length ;j++ ) {
                dp[i]+=dp[i-a[j]];
            }
        }
        System.out.println(dp[n]);
    }
}
