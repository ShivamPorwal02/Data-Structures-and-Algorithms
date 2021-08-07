package LoveBabbar.DynamicProgramming;

import java.util.Scanner;

public class CountDearrangements {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // soln

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

//        countDer(n) = (n - 1) * [countDer(n - 1) + countDer(n - 2)]
// there are two cases for this problem to break it in subproblems
        // hmare pass kisi element ko rkhne k (n-1) tarrke hai islia hm (n-1) se multiply krre hai

        // case 1 : ki agr jaise jis position prr hmne apna element rkha ussn uski hi position apply krli
                // swap ho gya to ab hmare pass subproblem (n-2) ki bchi
        // case 2 : vo element kisi aur jgh chla gya to hmari subproblem n-1 ki hogyi



        for(int i=3;i<=n;i++){
            dp[i] = (i-1)*(dp[i-1]+dp[i-2]);
        }
        System.out.println(dp[n]);
    }
}
