package LoveBabbar.DynamicProgramming;

import java.util.Scanner;

public class CoinGameWinnerwhereEveryPlayerhasThreeChoices {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int y = scn.nextInt();
        boolean[] dp = new boolean[n+1];

        // ye sbb hm A k lia krre hai agr true aaya to mtlb A jeet gya agr false aaya to B jeet gya

        dp[0] = false; // agr koi coin uthane ko hi ni to iska mtlb a haar gya
        dp[1] = true; // ek hi coin hai to a utha k jeet jaaega

        for(int i=2;i<=n;i++){

            // If A losses any of i-1 or i-x
            // or i-y game then he will
            // definitely win game i
            if(i-1>=0 && dp[i-1]==false){
                dp[i] = true;
            }else if(i-x>=0 && dp[i-x]==false){
                dp[i] = true;
            }else if(i-y>=0 && dp[i-y]==false){
                dp[i] = true;
            }else{
                dp[i] = false;
            }
        }
     }
}
