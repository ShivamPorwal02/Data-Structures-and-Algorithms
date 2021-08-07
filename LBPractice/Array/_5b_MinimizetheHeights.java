package LoveBabbar;

import java.util.Arrays;

public class _5b_MinimizetheHeights {
    public static int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int min_ele = 0;
        int max_ele = 0;
        int ans = arr[n-1]-arr[0];

        for(int i=1;i<n;i++){
            max_ele = Math.max(arr[i-1]+k,arr[n-1]-k);
            min_ele = Math.min(arr[0]+k,arr[i]-k);
            ans = Math.min(ans,max_ele-min_ele);
        }
        return ans;
    }
}
