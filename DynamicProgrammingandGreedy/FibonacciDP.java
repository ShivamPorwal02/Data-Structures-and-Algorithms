package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class FibonacciDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int fbn = FiboDp(n,new int[n+1]);
        System.out.println(fbn);
    }
    // a jo array hai usse hm qn bank kehte hai
    public static int FiboDp(int n,int[] a){
        if(n==0 || n==1){
            return n;
        }
        if(a[n]!=0){
            return a[n];
        }
        return FiboDp(n-1,a)+FiboDp(n-2,a);
    }
}
