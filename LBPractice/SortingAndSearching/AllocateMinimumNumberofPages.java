package LoveBabbar.SortingAndSearching;

public class AllocateMinimumNumberofPages {
    public static int findPages(int[]a,int n,int m)
    {
        //Your code here
        if(m>n) {
            return -1;
        }
        int sum = 0;
        int max = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
            sum+=a[i];
        }
        int i = max;
        int j = sum;
        int best = -1;
        while(i<=j){
            int mid = (i+j)/2;
            if(isValid(a,m,mid)){
                best = mid;
                j = mid-1;
            }else{
                i = mid+1;
            }

        }
        return best;
    }
    public static boolean isValid(int[] arr,int k,int mx){

        int sum = 0;
        int std = 1;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>mx){
                std++;
                sum = arr[i];
                if(std>k){
                    return false;
                }
            }

        }
        return true;
    }
}
