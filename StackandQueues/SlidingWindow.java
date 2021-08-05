package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class SlidingWindow {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        Stack<Integer> st = new Stack<>();
        int[] ger = new int[n];
        st.push(a.length-1);
        ger[a.length-1] = a.length; // "length" lelia jiska koi bda element hai hi ni
        for (int i=a.length-2;i>=0 ;i-- ) {
            while(st.size()>0 && a[i]>a[st.peek()]){
                st.pop();
            }
            if(st.empty()){
                ger[i] = a.length;
            }else{
                ger[i] = st.peek();
            }
            st.push(i);
        }
        int j=0;
        for (int i=0;i<=a.length-k ;i++ ) {
            if(j<i){
                j=i;
            }
            while(ger[j]<i+k){
                j=ger[j];
            }
            System.out.println(a[j]);
        }
    }
}

