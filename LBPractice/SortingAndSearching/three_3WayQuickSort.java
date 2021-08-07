package LoveBabbar.SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class three_3WayQuickSort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++ ) {
            arr[i] = scn.nextInt();
        }
        threewayQuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void threewayQuickSort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int i = low;
        int k = low + 1;
        int j = high;
        int pivot = nums[low];

        while(k<=j) {
            if(nums[k] < pivot) {
                swap(nums, i, k);
                i++;
                k++;
            }
            else if(nums[k] > pivot) {
                swap(nums, j, k);
            j--;
            }
            else
                k++;
        }
        threewayQuickSort(nums, low, i - 1);
        threewayQuickSort(nums, j + 1, high);
    }
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
