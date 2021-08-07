package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class TernarySearch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int key  = scn.nextInt();
        int pos = ternarySearch(arr,key);
        System.out.println(pos);
    }
    public static int ternarySearch(int[] arr, int key){
        int start=0;
        int end = arr.length-1;
        while(start<=end){
            int mid1 = start+(end-start)/3;
            int mid2 = mid1 + (end-start)/3;

            if(arr[mid1]==key){
                return mid1;
            }else if(arr[mid2]==key){
                return mid2;
            }
            if(arr[mid1]<key){
                end = mid1-1;
            }else if(key>arr[mid2]){
                start = mid2+1;
            }else{
                start = mid1+1;
                end = mid2-1;
            }
        }
        return -1;
    }
}
