package LoveBabbar.DynamicProgramming;

public class KadanesAlgo {
    int maxSubarraySum(int arr[], int n){

        // Your code here
        int csum=arr[0];
        int msum = arr[0];
        for(int i=1;i<arr.length;i++){
            if(csum>0) csum+=arr[i];
            else csum = arr[i];

            if(csum>msum) msum = csum;
        }
        return msum;
    }
}
