package DynamicProgrammingandGreedy;

import java.util.Arrays;
import java.util.Scanner;

public class BuySellStocksTwoTransaction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i] = scn.nextInt();
        }
        int lsf = a[0];
        int[] dp1 = new int[n];
        for (int i=1;i<n ;i++ ) {
            if(a[i]<lsf){
                lsf = a[i];
            }
            if(a[i]-lsf>dp1[i-1]){
                dp1[i] = a[i]-lsf;
            }else{
                dp1[i] = dp1[i-1];
            }
        }
        int[] dp2 = new int[n];
        int high = a[a.length-1];
        for (int i=a.length-2;i>=0;i-- ) {
            if(a[i]>high){
                high = a[i];
            }
            if(high-a[i]>dp2[i+1]){
                dp2[i] = high- a[i];
            }
            else {
                dp2[i] = dp2[i+1];
            }
        }
        int op =0;
        for (int i=0;i<a.length ;i++ ) {
            if (dp1[i] + dp2[i] > op) {
                op = dp1[i] + dp2[i];
            }
        }
        System.out.println(op);
    }
}
