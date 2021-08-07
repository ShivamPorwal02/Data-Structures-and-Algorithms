package Recursion;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int ans = power(n,r);
        System.out.println(ans);
    }
    public static int power(int n, int r){
        if(r==0){
            return 1;
        }
        return n*power(n,r-1);
    }
}
