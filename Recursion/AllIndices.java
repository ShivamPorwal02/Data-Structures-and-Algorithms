package Recursion;

import java.util.Scanner;

public class AllIndices {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]=scn.nextInt();
        }
        int x = scn.nextInt();
        int[] last = allIndices(a,x,0,0);
        for (int i=0;i<last.length ;i++ ) {
            System.out.println(last[i]);
        }
    }
    public static int[] allIndices(int[] a,int x,int idx,int fsf){
        if(idx == a.length){
            return new int[fsf];
        }
        if(a[idx]==x){
            int[] ans = allIndices(a,x,idx+1,fsf+1);
            ans[fsf]=idx;
            return ans;
        }else {
            int[]ans =allIndices(a,x,idx+1,fsf);
            return ans;
        }

    }
}
