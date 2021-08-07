package Recursion;

import java.util.Scanner;

public class PrintZigZag {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ppf(n);
    }
    public static void ppf(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" "); // Pre Order
        ppf(n-1);
        System.out.print(n+" "); // In Order
        ppf(n-1);
        System.out.print(n+" "); // Post Order
    }
}
