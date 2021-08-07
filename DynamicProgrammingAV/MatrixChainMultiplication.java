package DynamicProgrammingAV;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int minCost = MCM(arr,1,n-1);
        System.out.println(minCost);

        for (int[] row:dp ) {
            Arrays.fill(row,-1);
        }
        int minCost1 = MCMmemo(arr,1,n-1);
        System.out.println(minCost1);
    }
    // Recursive
    public static int MCM(int[] arr,int i,int j){
        if(i>=j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k=i;k<=j-1 ;k++ ) {
            int tempans = MCM(arr,i,k)+MCM(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(tempans<min){
                min = tempans;
            }
        }
        return min;
    }

    // Bottom Up(Memorization)
    static int[][] dp = new int[1001][1001];
    public static int MCMmemo(int[] arr,int i,int j){
        if(i>=j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        for (int k=i;k<=j-1 ;k++ ) {
            int tempans = MCMmemo(arr, i, k) + MCMmemo(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (min > tempans){
                min = tempans;
            }
        }
        return dp[i][j] = min;
    }
}
