package Recursion;

import java.util.Scanner;

public class TargetSumSubsets {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]=scn.nextInt();
        }
        int tar = scn.nextInt();
        printTargetSumSubsets(a,0,"",0,tar);
    }
    public static void printTargetSumSubsets(int[] a, int idx, String set, int sos, int tar) {
        if(idx==a.length){
            if(sos==tar){
                System.out.println(set+".");
            }
            return;
        }
        if(sos>tar){
            return;
        }
        printTargetSumSubsets(a,idx+1,set+a[idx]+", ",sos+a[idx],tar);
        printTargetSumSubsets(a,idx+1,set,sos,tar);
    }
}
