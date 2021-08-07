package Recursion;

import java.util.Scanner;

public class PowerLogarithmic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int ans = power(n,r);
        System.out.println(ans);
    }
    public static int power(int x, int r){
        if(r==0){
            return 1;
        }
        if(r%2==0){
            return power(x,r/2)*power(x,r/2);
        }else {
            return x*power(x,r/2)*power(x,r/2);
        }
    }
}

