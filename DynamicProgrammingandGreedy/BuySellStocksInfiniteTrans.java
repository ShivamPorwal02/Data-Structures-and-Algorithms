package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class BuySellStocksInfiniteTrans {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int lsf = a[0];
        int ans = 0;
        int i = 0;
        int flag = 0;
        for (i=1;i<a.length-1;i++ ) {
            if(a[i]<lsf){
                lsf= a[i];
                flag=0;
            }
            if(a[i+1]<a[i]){
                ans+=(a[i]-lsf);
                flag=1;
                lsf = Integer.MAX_VALUE;
            }

        }
        System.out.println(flag==0?ans+a[a.length-1]-lsf:ans);

        // bhaiya ka code //

        int bd = 0 ;
        int sd = 0;
        int profit = 0;
        for (i=1;i<a.length ;i++ ) {
            if(a[i]>a[i-1]){
                sd++;
            }else{
                profit+=(a[sd]-a[bd]);
                sd=bd = i;
            }
        }
        profit+=(a[sd]-a[bd]); // last stoke k lia
        System.out.println(profit);
    }
}
