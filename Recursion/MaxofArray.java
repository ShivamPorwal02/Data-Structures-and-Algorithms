package Recursion;

import java.util.Scanner;

public class MaxofArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]=scn.nextInt();
        }
       int max = maxOfArray(a,0);
        System.out.println(max);
    }
    public static int maxOfArray(int[] a,int idx){
        // base case
        // last element k aage to koi ni so whai hai maximum
        if(idx==a.length-1){
            return a[a.length-1];
        }
        // apne waale se apne aage se saare compare krr lete hai
        int misa = maxOfArray(a,idx+1);
        if(misa>a[idx]){
            return misa;
        }else {
            return a[idx];
        }
    }
}
