package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class PivotElementinSortedArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int ans = pivot(arr);
        System.out.println(ans);
    }
    public static int pivot(int[] arr){
        int i = 0;
        int j= arr.length-1;
        while(i<j){
            int mid = (i+j)/2;
            if(arr[mid]<arr[j]){
                j=mid;
            }else{
                i = mid+1;
            }
        }
        // No of times it is rotated --> j
        return arr[j];
    }
}
