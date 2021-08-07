package LoveBabbar;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumMergeOperationstoMakeArrayPallindrome {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int i=0;
        int j=arr.length-1;
        int res =0;
        while(i<j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }else if(arr[i]>arr[j]){
                j--;
                arr[j]+=arr[j-1];
                res++;
            }else{
                i++;
                arr[i]+=arr[i-1];
                res++;
            }
        }
        System.out.println(res);
    }
}
