package LoveBabbar;

import java.util.Arrays;
import java.util.Scanner;

public class _3_Sort0s1s2sinArray {
    public static void swap(int[] arr,int i,int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }

        int l = 0;
        int mid = 0;
        int h = arr.length-1;
        while(mid<=h){
            if(arr[mid]==0){
                swap(arr,l,mid);
                l++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                swap(arr,mid,h);
                h--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
