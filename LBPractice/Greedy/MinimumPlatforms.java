package LoveBabbar.Greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=1;
        int j=0;
        int ans = 1;
        int platform = 1;

        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                platform ++;
                i++;
            }else if(arr[i]>dep[j]){
                platform--;
                j++;
            }
            if(platform>ans) ans = platform;
        }
        return ans;
    }
}
