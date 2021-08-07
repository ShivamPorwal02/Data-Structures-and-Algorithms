package LoveBabbar.DynamicProgramming;

import java.util.Scanner;

public class SmallestSumContiguousArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }


        int csum = arr[0];
        int msum = arr[0];

        for(int i=1;i<arr.length;i++){
            if(csum<0) csum+=arr[i];
            else csum = arr[i];
            if(csum<msum) msum = csum;
        }
        System.out.println(msum);
    }
}
