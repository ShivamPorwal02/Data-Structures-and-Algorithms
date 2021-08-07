package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class SquareRootofInteger {
    public static int mySqrt(int x) {
        int ans = 0;
        for(long i=1;i*i<=x;i++){
            ans = (int)i;
        }
        return ans;
    }
    public static int method2(int x){
        // binary search
        if(x==1){
            return 1;
        }
        long i = 0;
        long j = x/2;
        int ans = 0;
        while(i<=j){
            long mid = (i+j)/2;
            if(mid*mid==(long)x){
                return (int)mid;
            }
            if(mid*mid<(long)x){
                ans = (int)mid;
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = mySqrt(n);
        System.out.println(ans);
    }
}
