package LoveBabbar.SortingAndSearching;

import java.util.Arrays;

public class WeightedJobScheduling_NLogN {
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
    public int maximum(Job[] jobs){
        int[] dp = new int[jobs.length];
        Arrays.sort(jobs,(a,b)->a.end-b.end);
        int omax = 0;
        dp[0] = jobs[0].profit;
        for (int i=1;i<jobs.length ;i++ ) {
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
    public int binarySearch(Job[] jobs,int index){
        int i=0;
        int j = jobs.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(jobs[mid].end<=jobs[index].start){
                if(jobs[mid+1].end<=jobs[index].start){
                    i=mid+1;
                }else{
                    return mid;
                }
            }else{
                j = mid-1;
            }
        }
        return -1;
    }
}
