package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelope {
    public class Doll implements Comparable<Doll>{
        int w;
        int h;
        Doll(int w,int h){
            this.w = w;
            this.h = h;
        }

        public int compareTo(Doll o){
            return this.w-o.w;
        }
    }
    public int maxEnvelopes(int[][] env) {
        Doll[] doll = new Doll[env.length];
        for(int i=0;i<env.length;i++){
            doll[i] = new Doll(env[i][0],env[i][1]);
        }
        Arrays.sort(doll);

        int[] dp = new int[env.length];
        int omax = 0;
        for(int i=0;i<env.length;i++){
            int max = 0 ;
            for(int j=0;j<i;j++){
                if(doll[i].w>doll[j].w && doll[i].h > doll[j].h){
                    if(dp[j]> max) max = dp[j];
                }
            }
            dp[i] = 1 + max;
            if(dp[i]>omax) omax = dp[i];
        }
        return omax;
    }
}
