package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToRight_Alternate {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i] = scn.nextInt();
        }
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i=1;i<a.length ;i++ ) {
            while(!st.empty() && a[i]>a[st.peek()]){
                int pos = st.peek();
                nge[pos] = a[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()){
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }
    }
}
