package LoveBabbar.SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort_InPlace {
    public static void main(String[] args) {

        // though iski abb complexity N2 ho jaaegi

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }
    public static void merge(int[] arr,int start,int mid,int end){
        int start2 = mid+1;
        while(start<=mid && start2<=end){
            if(arr[start]<arr[start2]){
                start++;
            }else{
                int temp = arr[start2];
                for(int i = start2-1;i>=start;i--){
                    arr[i+1] = arr[i];
                }
                arr[start] = temp;
                mid++;
                start++;
                start2++;
            }
        }
    }
}
