package RecursionAV;

import java.util.Scanner;

public class KthSymbolinGrammar {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int ans = Solve(n,k);
        System.out.println(ans);
    }
    public static int Solve(int n,int k){
        if(n==1 && k==1){
            return 0;
        }
        int mid = (int)Math.pow(2.0,n-1)/2;
        if(k<=mid){
            return Solve(n-1,k);
        }else{
            return Solve(n-1,k-mid)^1;
        }
    }
}
