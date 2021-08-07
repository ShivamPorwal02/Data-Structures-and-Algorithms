package Recursion;

import java.util.Scanner;

public class FirstIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]=scn.nextInt();
        }
        int x = scn.nextInt();
        int first = firstIndex(a,0,x);
        System.out.println(first);
    }
    public static int firstIndex(int[] a,int idx,int x){
        if(idx==a.length-1){
            if(a[idx]==x){
                return idx;
            }else {
                return -1;
            }
        }
//        int idxinsmall = firstIndex(a,idx+1,x);
//        if(a[idx]==x){
//            return idx;
//        }else {
//            return idxinsmall;
//        }
        // Better way would be ki isko pehle hi check krle and then else m daale
        if(a[idx]==x){
            return idx;
        }else{
            int idxinsmall = firstIndex(a,idx+1,x);
            return idxinsmall;
        }
    }
}

