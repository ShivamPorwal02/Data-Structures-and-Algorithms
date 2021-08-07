package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class WeighterJobSchedulling {
    // in O(N2)

    class Job{
        int start;
        int end;
        int profit;
        Job(int start,int end,int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[endTime.length];
        for(int i=0;i<endTime.length;i++){
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        return maximum(jobs);

    }
    public  int maximum(Job[] jobs){
        int[] dp = new int[jobs.length];
        Arrays.sort(jobs,(a, b)->a.end-b.end);
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
        return omax;
    }

    // O(NLogN)

    public int jobScheduling_(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[endTime.length];
        for(int i=0;i<endTime.length;i++){
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        return maximum(jobs);

    }
    public  int maximum_(Job[] jobs){
        int[] dp = new int[jobs.length];
        Arrays.sort(jobs,(a,b)->a.end-b.end);
        int omax = 0 ;
        dp[0] = jobs[0].profit;
        for(int i=1;i<jobs.length;i++){
            int max = jobs[i].profit;
            int l = binarySearch(jobs,i);
            if(l!=-1){
                max+=dp[l];
            }
            dp[i] = Math.max(dp[i-1],max);
            if(dp[i]>omax){
                omax = dp[i];
            }
        }
        return omax;
    }
    public int binarySearch(Job jobs[], int index)
    {
        // Initialize 'lo' and 'hi' for Binary Search
        int lo = 0, hi = index - 1;

        // Perform binary Search iteratively
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (jobs[mid].end <= jobs[index].start)
            {
                if (jobs[mid + 1].end <= jobs[index].start)
                    lo = mid + 1;
                else
                    return mid;
            }
            else
                hi = mid - 1;
        }

        return -1;
    }

}
