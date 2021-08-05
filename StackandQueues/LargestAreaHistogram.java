package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i] = scn.nextInt();
        }
        int[] rb = new int[n];  // right smaller
        Stack<Integer> st = new Stack<>();
        st.push(a.length-1);
        rb[a.length-1]=a.length;
        for (int i=a.length-2;i>=0 ;i-- ) {
            while (!st.empty() && a[i]<a[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                rb[i] = a.length;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }
        int[] lb = new int[n]; // left smaller
        st = new Stack<>();
        st.push(0);
        lb[0]=-1;
        for (int i=1;i<a.length ;i++ ) {
            while (!st.empty() && a[i]<a[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }
        int maxarea = 0;
        for (int i=0;i<a.length ;i++ ) {
            int width = rb[i]-lb[i]-1;
            int area = a[i]*width;
            if(area>maxarea){
                maxarea=area;
            }
        }
        System.out.println(maxarea);
    }
}
