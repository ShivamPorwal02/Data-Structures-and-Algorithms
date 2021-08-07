package LoveBabbar.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    int maxChainLength(Pair arr[], int n)
    {
        // your code here
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.x-o2.x;
            }
        });

        int[] dp = new int[n];

        int omax = 0;
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[j].y<arr[i].x){
                    if(dp[j]>max) max = dp[j];
                }
            }
            dp[i] = 1+max;
            if(dp[i]>omax) omax = dp[i];
        }
        return omax;
    }
}
