package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class PainterPartitionProblem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int time = minimumTime(arr,k);
        System.out.println(time);
    }
    public static int minimumTime(int[] arr,int k){
        int sum = 0;
        for (int i=0;i<arr.length ;i++ ) {
            sum+=arr[i];
        }
        int i= 0 ; // isko agr aur optimize krna hai to isko max of array se bhi le skt hai
        int j = sum;
        int best = 0;
        while(i<=j){
            int mid = (i+j)/2;
            if(isValid(arr,mid,k)){
                best = mid;
                j = mid-1;
            }else {
                i = mid + 1;
            }
        }
        return best;
    }
    public static boolean isValid(int[] arr,int mx,int k){
        int cnt = 1;
        int sum = arr[0];
        for(int i=1;i<arr.length;i++){
            sum+=arr[i];
            if(sum>mx){
                cnt++;
                if(cnt>k){
                    return false;
                }
                sum = arr[i];
            }
        }
        return true;
    }
}
