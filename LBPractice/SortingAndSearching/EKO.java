package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class EKO {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] trees = new int[n];
        int metre = scn.nextInt();
        for (int i=0;i<n;i++){
            trees[i] = scn.nextInt();
        }
        int ans = minimum(trees,metre);
        System.out.println(ans);
    }
    public static int minimum(int[] arr,int metre){
        int min = 0;
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int i = min;
        int j = max;
        int best =-1;
        while(i<=j) {
            int mid = (i+j)/2;
            if(cuttedPart(arr,mid)==metre){
                best= mid;
                i=mid+1;
            }else if(cuttedPart(arr,mid)<metre){
                j=mid-1;
            }else{
                i = mid+1;
            }
        }
        return best;
    }
    public static int cuttedPart(int[] arr,int mid){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid) {
                sum += (arr[i]-mid);
            }
        }
        return sum;
    }
}
