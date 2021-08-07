package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class BuySellStocksOneTransactionAllowd {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i] = scn.nextInt();
        }
        int min = a[0];
        int max = 0;
        int diff = 0;
        int max_diff = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                max = 0;
            }
            if (a[i] > max) {
                max = a[i];
            }
            diff = max - min;
            if (diff > max_diff) {
                max_diff = diff;
            }
        }
        System.out.println(max_diff);
    }
}

 /// Bhaiya waala
//
//int lsf = Integer.MAX_VALUE;
//int op = 0;
//int list = 0;
//for(int i = 0;i<a.length;i++){
//    if(a[i]<psf){
//        psf = a[i];
//    }
//    pist = a[i] - lsf;
//    if(pist>op){
//        op = pist;
//    }
//}
//System.out.prinln(op);
