package LoveBabbar.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DoubleHelix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i=0;i<b.length ;i++ ) {
            b[i] = scn.nextInt();
        }
        int ans = maximumSum(a,b);
        System.out.println(ans);
    }
    public static int maximumSum(int[] a,int[] b){
        int i = 0;
        int j = 0;
        int sum1 = 0;
        int sum2 = 0;
        int omax = 0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                sum1+=a[i];
                i++;
            }else if(b[j]<a[i]){
                sum2+=b[j];
                j++;
            }else{
                omax+=(Math.max(sum1,sum2)+a[i]);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while(i<a.length){
            sum1+=a[i];
            i++;
        }
        while(j<b.length){
            sum2+=b[j];
            j++;
        }
        omax+=Math.max(sum1,sum2);
        return omax;
    }
}
