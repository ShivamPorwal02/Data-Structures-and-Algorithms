package Revision;

public class CountInversions {
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long[] temp = new long[(int)N];
        return _mergeSort(arr,temp,0,arr.length-1);

    }
    public static long _mergeSort(long[] arr, long[] temp,int low,int high){
        int mid = 0;
        long inv = 0;
        if(low<high){
            mid = (low+high)/2;
            // mid mtlb phle array ka last


            inv+=_mergeSort(arr,temp,low,mid);
            inv+=_mergeSort(arr,temp,mid+1,high);

            inv+=inversions(arr,temp,low,mid+1,high);
        }
        return inv;
    }
    public static long inversions(long[] arr,long[] temp,int left,int mid,int right){

        int i = left;
        int j = mid;
        int k = left;

        long inv_cnt = 0;

        while(i<=mid-1 && j<=right){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                inv_cnt= inv_cnt+ (mid-i);
            }
        }
        while(i<=mid-1){
            temp[k++] = arr[i++];
        }
        while(j<=right){
            temp[k++] = arr[j++];
        }
        for(int idx=left;idx<=right;idx++) arr[idx] = temp[idx];

        return inv_cnt;
    }
}
