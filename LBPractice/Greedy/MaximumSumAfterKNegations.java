package LoveBabbar.Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumSumAfterKNegations {
    public int largestSumAfterKNegations(int[] a, int k) {
        /// method 1
        int sum =0 ;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(a[i]<0){
                lst.add(a[i]);
            }else{
                min = Math.min(min,(int)a[i]);
                sum+=a[i];
            }
        }

        Collections.sort(lst);
        int x = k;

        for(int item : lst){
            if(x!=0){
                sum+=(-item);
                x--;
            }
            else sum+=item;
        }

        if(x!=0 && x%2!=0){
            if(lst.size()!=0){
                if(Math.abs(lst.get(lst.size()-1)) > min) return sum-2*min;
                else return sum-2*Math.abs(lst.get(lst.size()-1));
            }else return sum-2*min;
        }
        return sum;
    }

    // method 2 priority queue


}
