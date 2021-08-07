package Recursion;

import java.util.Scanner;

public class Factorial {
    public static int Fact(int n){
        if(n==0 || n==1){
            return n;
        }
        return n*Fact(n-1);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = Fact(n);
        System.out.println(ans);
    }
}
