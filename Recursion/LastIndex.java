package Recursion;

import java.util.Scanner;

public class LastIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]=scn.nextInt();
        }
        int x = scn.nextInt();
        int last = lastIndex(a,n,x);
        System.out.println(last);
    }
    public static int lastIndex(int[] a,int idx,int x){
        if(idx==0){
            if(a[idx]==x){
                return idx;
            }
            else {
                return -1;
            }
        }
        if(a[idx-1]==x){
            return idx;
        }else{
            int before = lastIndex(a,idx-1,x);
            return before;
        }
    }
}
