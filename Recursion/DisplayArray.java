package Recursion;

import java.util.Scanner;

public class DisplayArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]=scn.nextInt();
        }
        displayArr(a,n);
    }
    public static void displayArr(int[] a,int n){
        if(n==0){
            return;
        }
        displayArr(a,n-1);
        System.out.println(a[n-1]);
    }
}
