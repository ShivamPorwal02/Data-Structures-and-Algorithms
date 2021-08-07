package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int steps=NoofSteps(n,new int[n+1]);
        System.out.println(steps);
        int ans = Tabular(n);
        System.out.println(ans);
    }

    // TABULATION //
    public static int Tabular(int n){
        int[] table = new int[n+1];
        table[0]=1;
        for (int i=1;i<=n ;i++ ) {
            if(i==1){
                table[i] = table[i-1];
            }else if(i==2){
                table[i] = table[i-1]+table[i-2];
            }else{
                table[i]=table[i-1]+table[i-2]+table[i-3];
            }
        }
        return table[n];

    }

    // Memorization //

    public static int NoofSteps(int n,int[] a){
        if(n==0){
            return 1;
        }
        if(n<0) {
            return 0;
        }
        if(a[n]!=0){
            return a[n];
        }
        int x1 = NoofSteps(n - 1,a);
        int x2 = NoofSteps(n - 2,a);
        int x3 = NoofSteps(n - 3,a);
        a[n]=x1+x2+x3; //Memorization
        return x1 + x2 + x3;

    }
}
