package LoveBabbar.StackandQueues;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstNegativeIntegerinEveryWindowofSizeK {
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        Queue<Long> q = new ArrayDeque<>();

        int size = n;


        int i = 0;
        int j = 0 ;
        int idx = 0;

        long[] ans = new long[n-k+1];
        while(j<size){

            if(arr[j] < 0)  q.add(arr[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){

                if(q.size()>0) ans[idx] = q.peek();
                else ans[idx] = 0;

                if(q.size() > 0 && arr[i]==q.peek()) q.remove();
                i++;
                j++;
                idx++;
            }
        }
        return ans;
    }
}
