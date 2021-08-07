package LoveBabbar.Greedy;

import java.util.Arrays;

public class MaximumSumarrelementmultiplybyi {
    int Maximize(int arr[], int n)
    {
        // Complete the function
        Arrays.sort(arr);
        int mod = (int)Math.pow(10,9)+7;
        long ans = 0;
        for(int i=0;i<n;i++){
            ans+=(i*(long)arr[i]);
            ans = (ans<0 ? ans+mod : ans)%mod;
        }
        return (int)ans%mod;
    }
}
