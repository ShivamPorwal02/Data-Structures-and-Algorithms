package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    // indexes k through krdia hai indexes push krwadia hai //
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++) {
            a[i] = scn.nextInt();
        }
        int[] ans = new int[n];
        ans[0] = 1;
        Stack<Integer> st =  new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++){
            while (st.size()>0 && a[i]>a[st.peek()]){
                st.pop();
            }
            if(st.empty()){
                ans[i] = i+1;
            }else{
                ans[i] = i-st.peek();
            }
            st.push(i);
        }
        for (int i=0;i<n ;i++ ) {
            System.out.println(ans[i]);
        }
    }
}
