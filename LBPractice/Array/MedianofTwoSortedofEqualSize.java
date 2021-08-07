package LoveBabbar;

import java.util.Scanner;

public class MedianofTwoSortedofEqualSize {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0;i<n ;i++ ) {
            a[i] = scn.nextInt();
        }
        for (int i=0;i<n ;i++ ) {
            b[i] = scn.nextInt();
        }
        double ans = Median(a,b,0,a.length-1,0,b.length-1);
        System.out.println(ans);
    }
    public static double Median(int[] a,int[] b,int start_a,int end_a,int start_b,int end_b){
        if(end_a-start_a==1 && end_b-start_b==1){
            return (1.0*(Math.max(a[start_a],b[start_b]))+Math.min(a[end_a],b[end_b]))/2;
        }
        int m1_idx = (start_a+end_a)/2;
        int m2_idx = (start_b+end_b)/2;

        int m1 = a[m1_idx];
        int m2 = b[m2_idx];
        if(m1==m2){
            return m1;
        }
        if(m1<m2){
            start_a = m1_idx;
            end_b = m2_idx;
        }else{
            end_a = m1_idx;
            start_b = m2_idx;
        }
        return Median(a,b,start_a,end_a,start_b,end_b);
    }
}
