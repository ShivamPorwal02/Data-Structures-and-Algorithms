package LoveBabbar.SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class AggresiveCows {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t>0){
            int n = scn.nextInt();
            int c = scn.nextInt();
            int[] stalls = new int[n];
            for (int i=0;i<stalls.length ;i++ ) {
                stalls[i] = scn.nextInt();
            }
            int ans = minDistance(stalls,c);
            System.out.println(ans);
            t--;
        }

    }
    public static int minDistance(int[] arr,int c){
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        int best = 0;
        while(i<=j){
            int gap = (i+j)/2;
            int cntcows = 1;
            int leftcow = 0;
            for (int x=0;x<arr.length ;x++ ) {
                if(arr[x]-arr[leftcow]>=gap){
                    leftcow = x;
                    cntcows++;
                }
            }
            if(cntcows>=c){
                best = gap;
                i=gap+1;
            }else{
                j = gap-1;
            }
        }
        return best;
    }

}
