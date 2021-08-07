package Revision;

import java.util.Arrays;

public class MinimumPlatforms {

    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int max = 1;
        int cnt = 1;
        int i = 1;
        int j = 0;

        while(i!=arr.length && j!=dep.length){
            if(arr[i]<=dep[j]){
                cnt++;
                max = Math.max(cnt,max);
                i++;
            }
            else{
                cnt--;
                j++;
            }
        }
        return max;
    }
}
