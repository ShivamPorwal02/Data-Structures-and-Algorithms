package LoveBabbar.SortingAndSearching;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int i = arr1.length-1;
        int j = 0;
        while(j<arr2.length && i>=0){
            if(arr1[i]>arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
            }
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
