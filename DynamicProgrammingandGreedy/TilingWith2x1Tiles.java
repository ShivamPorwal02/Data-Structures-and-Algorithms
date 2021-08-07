package DynamicProgrammingandGreedy;
import java.util.Scanner;

public class TilingWith2x1Tiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = tiles(n);
        System.out.println(ans);
    }
    static int[] dp =new int[101];
    public static int tiles(int n){
        if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return dp[n]=tiles(n-1)+tiles(n-2);
    }
}
