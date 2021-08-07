package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class AssemblyLineScheduling {
    public static void main (String[] args)
    {
        int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int e[] = {10, 12}, x[] = {18, 7};

        System.out.println(carAssembly(a, t, e, x));

    }
    public static int carAssembly(int[][] arr,int[][] t,int[] e,int[] x){

        int[][] dp = new int[2][arr[0].length+2];

        dp[0][0] = e[0];
        dp[1][0] = e[1];

        dp[0][dp[0].length-1] = x[0];
        dp[1][dp[0].length-1] = x[1];

        dp[0][1] = dp[0][0]+arr[0][0];
        dp[1][1] = dp[1][0]+arr[1][0];
        for(int j=2;j<=arr[0].length;j++){
            for(int i=0;i<2;i++){
                if(i==0){
//                    System.out.println(arr[i][j-1]+" "+t[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j-1]+arr[i][j-1],dp[i+1][j-1]+arr[i][j-1]+t[1][j-1]);
                }else if(i==1){

//                    System.out.println(arr[i][j-1]+" "+t[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j-1]+arr[i][j-1],dp[i-1][j-1]+arr[i][j-1]+t[0][j-1]);
                }
            }
        }
        dp[0][dp[0].length-1] += dp[0][dp[0].length-2];
        dp[1][dp[0].length-1] += dp[1][dp[0].length-2];
        for(int[] x1: dp) System.out.println(Arrays.toString(x1));
        return Math.min(dp[0][dp[0].length-1],dp[1][dp[0].length-1]);
    }
}
