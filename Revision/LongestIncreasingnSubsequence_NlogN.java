package Revision;

import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingnSubsequence_NlogN {
    static int longestSubsequence(int size, int arr[])
    {
        // code here
        ArrayList<Integer> lst = new ArrayList<>();

        lst.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(lst.get(lst.size()-1) < arr[i]) lst.add(arr[i]);
            else{
                int idx = Collections.binarySearch(lst,arr[i]);
                if(idx<0) idx = -(idx) -1;
                lst.set(idx,arr[i]);
            }
        }
        return lst.size();
    }
}
