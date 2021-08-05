package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToRight {
    public static void main(String[] arr) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        st.push(a[n-1]);
        int j = n-2;
        int[] ans = new int[n];
        ans[n-1]=-1;
        for (int i = n-2; i >= 0; i--) {
            if (st.peek() > a[i]) {
                ans[j] = st.peek();
                st.push(a[i]);
                j--;
            } else if (!st.empty()&&st.peek() < a[i]) {
                while(!st.empty()&&st.peek()<a[i]){
                    st.pop();
                }
                if(st.empty()) {
                    ans[j] = -1;
                }else{
                    ans[j] = st.peek();
                }
                st.push(a[i]);
                j--;
            }
        }
        for (int i=0;i<n ;i++ ) {
            System.out.println(ans[i]);
        }
    }
}
