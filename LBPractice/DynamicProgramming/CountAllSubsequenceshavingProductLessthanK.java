package LoveBabbar.DynamicProgramming;

import java.util.Scanner;

public class CountAllSubsequenceshavingProductLessthanK {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        int[][] dp = new int[n+1][k+1];


        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<k+1;j++ ) {
                if(arr[i-1]<=j && arr[i-1]>0){
                    dp[i][j] = dp[i-1][j/arr[i-1]] +dp[i-1][j]+ 1; // +1 islia kia hai kyuki vo khud bhi akela ek bna skta hai jaise 6<9 hai to akela 6 bhi 9 se to chota hi hai
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
