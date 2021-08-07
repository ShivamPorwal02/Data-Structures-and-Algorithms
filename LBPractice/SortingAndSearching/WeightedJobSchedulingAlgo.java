package LoveBabbar.SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class WeightedJobSchedulingAlgo {
    // ye N2 m hai ek test case fail hora hai

    static class Job{
        int start;
        int end;
        int profit;
        Job(int start,int end,int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public static int maximum(Job[] jobs){
        int[] dp = new int[jobs.length];
        Arrays.sort(jobs,(a,b)->a.end-b.end);
        for (int i = 0;i<jobs.length;i++ ) {
            System.out.println(jobs[i].end);
        }
        int omax = 0 ;
        dp[0] = jobs[0].profit;
        for(int i=1;i<jobs.length;i++){
            int startPoint = jobs[i].start;
            int max = 0;
            for(int j=0;j<i;j++){
                if(startPoint>=jobs[j].end){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = jobs[i].profit+max;
            if(dp[i]>omax){
                omax = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return omax;
    }
    public static void main(String[] args) {
        Job[] jobs = new Job[5];
        jobs[0] = new Job(1,3,20);
        jobs[1] = new Job(2,5,20);
        jobs[2] = new Job(3,10,100);
        jobs[3] = new Job(4,6,70);
        jobs[4] = new Job(6,9,60);
//        jobs[5] = new Job(7,9,2);
        int ans = maximum(jobs);

        System.out.println(ans);
    }
}
