package LoveBabbar;

import java.util.Scanner;

public class BuySell_2Transaction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int mpisf = 0;
        int lsf = arr[0];
        int[] dp1 = new int[n];

        for(int i=1;i<arr.length;i++){
            if(arr[i]<lsf){
                lsf = arr[i];
            }
            mpisf = arr[i] - lsf;
            if(mpisf>dp1[i-1]){
                dp1[i] = mpisf;
            }else{
                dp1[i] = dp1[i-1];
            }
        }
        int mpibf = 0;
        int hsf = arr[arr.length-1];
        int[] dp2 = new int[n];

        for(int i=arr.length-2;i>=0;i--) {
            if (arr[i] > hsf) {
                hsf = arr[i];
            }
            mpibf = hsf - arr[i] ;
            if (mpibf > dp2[i + 1]) {
                dp2[i] = mpibf;
            } else {
                dp2[i] = dp1[i + 1];
            }
        }
        int omax = 0;
        for (int i=0;i<dp1.length ;i++ ) {
            if(dp1[i]+dp2[i]>omax){
                omax = dp1[i] + dp2[i];
            }
        }
        System.out.println(omax);
    }
}
