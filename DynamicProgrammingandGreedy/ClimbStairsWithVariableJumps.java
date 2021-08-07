package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class ClimbStairsWithVariableJumps {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<a.length ;i++ ) {
            a[i]=scn.nextInt();
        }
        int[] qn = new int[n+1];
        int ans = VariableJumps(0,n,a,qn);
        System.out.println(ans);
        jumps(n,a);

    }
    public static int VariableJumps(int x,int n, int[] a,int[] qn){
        // Memorization //
        if(n==x){
            return 1;
        }
        if(x>n){
            return 0;
        }
        if(qn[x]!=0){
//            System.out.println(n);
            return qn[x];
        }
        int sum=0;
        for (int j=1;j<=a[x] ;j++ ) {
            sum+=VariableJumps(x+j,n,a,qn);
        }
        qn[x]=sum;
        return qn[x];
    }

    // Tabulation // (Sir wala)
    public static void jumps(int n,int[] a){
        int[] dp = new int[n+1];
        dp[n] = 1; //6 se 6 jaane k ek hi rasta hai
        for (int i = n-1;i>=0;i--) {
            for (int j = 1;j<=a[i] && i+j<dp.length;j++){
                dp[i]+=dp[i+j];

            }
        }
        System.out.println(dp[0]);
    }
}
