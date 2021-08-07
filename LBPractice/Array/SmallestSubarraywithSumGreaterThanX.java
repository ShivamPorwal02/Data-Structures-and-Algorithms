package LoveBabbar;

import java.util.HashSet;
import java.util.Set;

public class SmallestSubarraywithSumGreaterThanX {

    public static long sb(long arr[], long n, long x) {
        // Your code goes here
        long mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                sum+=arr[j];
                if(sum>x)
                {
                    mini=Math.min(mini,j-i+1);
                    break;
                }
            }
        }
        return mini;
    }
}
