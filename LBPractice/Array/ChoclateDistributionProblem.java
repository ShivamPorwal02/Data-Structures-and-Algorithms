package LoveBabbar;

import java.util.ArrayList;
import java.util.Collections;

public class ChoclateDistributionProblem {
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        Collections.sort(a);
        // System.out.println(a);
        long min = Integer.MAX_VALUE;
        int i = 0;
        int j=(int)m-1;
        while(j<a.size()){
            if(a.get(j)-a.get(i)<min){
                min = a.get(j)-a.get(i);
            }
            i++;
            j++;
        }

        return min;
    }
}
