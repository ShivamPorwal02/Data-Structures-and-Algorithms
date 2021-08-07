package LoveBabbar.Greedy;

import java.util.Scanner;

public class BuyMaximumStocksif_i_stocksCanBeBoughton_ith_day {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int ans = 0;
        for (int i=0;i<n ;i++ ) {
            ans += Math.min((i+1), k / arr[i]);
            k -= arr[i] * Math.min((i+1),
                    (k / arr[i]));
        }
        System.out.println(ans);
    }
}
