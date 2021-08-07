package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class BuySellStocksCooldownInfiniteTrans {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i] = scn.nextInt();
        }
//        int[] bsp = new int[n];
//        int[] ssp = new int[n];
//        bsp[0]=-a[0];
//        ssp[0]=0;
//        for (int i=1;i<n ;i++ ) {
//            if(i>=2 && ssp[i-2]-a[i]>bsp[i-1]){
//                bsp[i]=ssp[i-2]-a[i];
//            }else{
//                bsp[i]=bsp[i-1];
//            }
//            if(bsp[i-1]+a[i]>ssp[i-1]){
//                ssp[i] = bsp[i-1]+a[i];
//            }
//            else {
//                ssp[i]=ssp[i-1];
//            }
//        }
//        for (int i=0;i<n ;i++ ) {
//            System.out.print(bsp[i]+" ");
//        }
//        System.out.println();
//        for (int i=0;i<n ;i++ ) {
//            System.out.print(ssp[i]+" ");
//        }
//        System.out.println();
//        System.out.println(ssp[n-1]);

        int obsp = -a[0];
        int ossp = 0 ;
        int ocsp = 0;
        for (int i=1;i<n ;i++ ) {
            int nbsp = 0;
            int nssp = 0 ;
            int ncsp = 0;

            if(ocsp-a[i]>obsp){
                nbsp = ocsp-a[i];
            }else{
                nbsp = obsp;
            }
            if(obsp+a[i]>ossp){
                nssp = obsp+a[i];
            }else{
                nssp = ossp;
            }
            if(ossp>ocsp){
                ncsp = ossp;
            }else{
                ncsp = ocsp;
            }
            ossp = nssp;
            obsp = nbsp;
            ocsp = ncsp;
        }
        System.out.println(ossp);
    }
}
