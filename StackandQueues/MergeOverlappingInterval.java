package StackandQueues;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MergeOverlappingInterval {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][2];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<2 ;j++ ) {
                a[i][j] = scn.nextInt();
            }
        }
        merge(a);

    }
    public static void merge(int[][] a){
        Pair[] pairs = new Pair[a.length];
        for (int i =0 ;i<a.length ;i++ ) {
            pairs[i] = new Pair(a[i][0],a[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<pairs.length;i++){
            if(i==0){
                st.push(pairs[i]);
            }else{
                Pair top = st.peek();

                if(pairs[i].st>top.en){
                    st.push(pairs[i]);
                }else{
                    top.en = Math.max(top.en,pairs[i].en);
                }
            }
        }
        Stack<Pair> ans = new Stack<>();
        while(st.size()>0) {
            ans.push(st.pop());
        }

        while (ans.size()>0) {
            Pair p = ans.pop();
            System.out.println(p.st+" "+p.en);
        }
    }
    public static class Pair implements Comparable<Pair>{
        int st;
        int en;

        Pair(int st,int en){
            this.st = st;
            this.en = en;
        }

        // this>other return +ve
        // this==other return 0
        // this<other return -ve
        public int compareTo(Pair other){
            if(this.st!=other.st){
                return this.st-other.st;
            }else {
                return this.en-other.en;
            }
        }
    }
}
