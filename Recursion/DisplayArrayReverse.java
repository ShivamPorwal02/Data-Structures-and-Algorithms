package Recursion;

import java.util.Scanner;

public class DisplayArrayReverse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]= scn.nextInt();
        }
        displayArrReverse(a,n);
    }
    public static void displayArrReverse(int[] a,int n){
        if(n==0){
            return;
        }
        System.out.println(a[n-1]);
        displayArrReverse(a,n-1);
    }
}
