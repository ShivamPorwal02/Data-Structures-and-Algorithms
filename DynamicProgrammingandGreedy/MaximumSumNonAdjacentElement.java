package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class MaximumSumNonAdjacentElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        // Greedy
        int inc = a[0];
        int exc = 0;
        for (int i=1;i<a.length ;i++ ) {
            int ninc = exc+a[i];
            int nexc = Math.max(inc,exc);

            inc = ninc;
            exc = nexc;
        }
        int ans = Math.max(inc,exc);
        System.out.println(ans);

        int x = MaxSum(a, n);
        System.out.println(x);
    }
    // Dynamic(using Memo)
    static int[] dp = new int[1001];
    public static int MaxSum(int[] a, int n) {
        if (n == 0 || a.length == 0 || n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int x = MaxSum(a, n - 1);
        int y = a[n - 1] + MaxSum(a, n - 2);
        dp[n] = Math.max(x, y);
        return Math.max(x, y);
    }
}
