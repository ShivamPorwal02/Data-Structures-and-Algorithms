package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class SearchinginAnArrayWhereAdjacentDifferbyAtmostK {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int  n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int key = scn.nextInt();
        int ans = index(arr,k,key);
        System.out.println(ans);
    }
    public static int index(int[] arr,int k,int key){
        int i=0;
        while (i< arr.length){
            if(arr[i]==key){
                return i;
            }
            i = i+Math.max(1,Math.abs(arr[i]-key)/k);
        }
        return -1;
    }
}
