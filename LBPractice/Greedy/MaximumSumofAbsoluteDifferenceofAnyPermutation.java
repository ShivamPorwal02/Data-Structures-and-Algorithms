package LoveBabbar.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumofAbsoluteDifferenceofAnyPermutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        Arrays.sort(arr);
        int[] arr2 = new int[n];
        int i = 0;
        int j=arr.length-1;

        int k = 0;
        while(i<j){
            arr2[k] = arr[i];
            k++;
            arr2[k] = arr[j];
            k++;
            i++;
            j--;
        }
        if(i==j) arr2[k] = arr[i];

        int ans = 0;
        for(i=0;i<arr2.length;i++){
            ans+=(Math.abs(arr2[i]-(i==arr2.length-1 ? arr2[0] : arr2[i+1])));
        }
        System.out.println(ans);
    }
}
