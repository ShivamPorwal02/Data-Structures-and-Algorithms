package LoveBabbar.Greedy;

import java.util.PriorityQueue;

public class MinimumCostofRopes {
    long minCost(long arr[], int n)
    {
        // your code here
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(long x : arr){
            pq.add(x);
        }

        long ans = 0 ;
        long sum = 0;
        while(pq.size()!=1){
            long x = pq.remove();
            long y = pq.remove();
            sum = x + y;
            ans+=(x+y);
            pq.add(sum);
        }
        return ans;
    }
}
