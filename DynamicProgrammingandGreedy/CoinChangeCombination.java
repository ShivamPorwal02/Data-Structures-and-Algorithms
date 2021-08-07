package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class CoinChangeCombination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        // Aditya Verma

        // Aditya Verma ka tareeka hai but i dont know why 2 cases fail hore 0 wale
//        int[][] dp = new int[n+1][tar+1];
//        for (int j=0;j<dp[0].length ;j++ ) {
//            dp[0][j] = 0;
//        }
//        for (int i=0;i<dp.length ;i++ ) {
//            dp[i][0]=1;
//        }
//        for (int i=1;i<dp.length ;i++ ) {
//            for (int j=1;j<dp[0].length ;j++ ) {
//                if(a[i-1]<=j &&a[i-1]!=0){
//                    dp[i][j] = (dp[i][j-a[i-1]]+dp[i-1][j]);
//                }
//                else{
//                    dp[i][j]= dp[i-1][j];
//                }
//            }
//        }
//        System.out.println(dp[n][tar]);

        // PEPCODING

        int[] dp = new int[tar + 1];
        for (int i = 0; i < a.length; i++) {
            dp[0]=1;
            for (int j = a[i]; j < dp.length; j++) {
                dp[j] += dp[j-a[i]];
            }
        }
        System.out.println(dp[tar]);

    }
    }
