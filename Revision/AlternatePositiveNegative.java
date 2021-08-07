package Revision;

import java.util.Arrays;
import java.util.Scanner;

public class AlternatePositiveNegative {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        rearrange(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    static void rearrange(int arr[], int n) {
        // code here
        int i=0;
        int j = 1;

        while(i<arr.length && j<arr.length){
            if(i%2==0 && arr[i]<0 && j%2!=0 && arr[j]>=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(i%2==0 && arr[i]>=0) i+=2;
            if(j%2!=0 && arr[j]<0) j+=2;
            System.out.println(i+" "+j);
        }
        // return arr;
    }
}
