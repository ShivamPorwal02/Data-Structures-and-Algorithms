package DynamicProgrammingAV;

import java.util.Arrays;
import java.util.Scanner;

public class EggDroppingProblem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int e = scn.nextInt();
        int f = scn.nextInt();
        int ans = EggDrop(e,f);
        System.out.println(ans);

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans1 = eggDrop(e,f);
        System.out.println(ans1);

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans2 = eggdrop(e,f);
        System.out.println(ans2);
    }
    public static int EggDrop(int e,int f){
        if(e==1){
            return f;
        }
        if(f==0 || f==1){
            return f;
        }
        int min = Integer.MAX_VALUE;
        for (int k=1;k<=f ;k++ ) {
            int tempans = 1+Math.max(EggDrop(e-1,k-1),EggDrop(e,f-k)); // max islia lia hai kyuki worst case hai
            // agr smjh ni aara to niche video AV k comments pdho
            min = Math.min(min,tempans);
        }
        return min;
    }
    // MEMORIZATION
    static int[][] dp = new int[1001][10001];
    public static int eggDrop(int e,int f){
        if(e==1){
            return f;
        }
        if(f==0 || f==1){
            return f;
        }
        if(dp[e][f]!=-1){
            return dp[e][f];
        }
        int min = Integer.MAX_VALUE;
        for (int k=1;k<=f ;k++ ) {
            int tempans = 1+Math.max(EggDrop(e-1,k-1),EggDrop(e,f-k)); // max islia lia hai kyuki worst case hai
            // agr smjh ni aara to niche video AV k comments pdho
            min = Math.min(min,tempans);
        }
        return dp[e][f]=min;
    }
    // Memorization Optimization
    public static int eggdrop(int e,int f){
        if(e==1){
            return f;
        }
        if(f==0 || f==1){
            return f;
        }
        if(dp[e][f]!=-1){
            return dp[e][f];
        }
        int min = Integer.MAX_VALUE;
        int low = 0;
        int right = 0;
        for (int k=1;k<=f ;k++ ) {
            if(dp[e-1][k-1]!=-1){
                low =  dp[e-1][k-1];
            }else{
                low = eggdrop(e-1,k-1);
                dp[e-1][k-1] = low;
            }
            if(dp[e][f-k]!=-1){
                right =  dp[e][f-k];
            }else{
                right = eggdrop(e,f-k);
                dp[e][f-k] = right;
            }
            int tempans = 1+Math.max(low,right);
            min = Math.min(tempans,min);
        }
        return dp[e][f] =min;
    }
}
