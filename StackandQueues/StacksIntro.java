package StackandQueues;

import java.util.Stack;

public class StacksIntro {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st);
        int a = st.peek();
        System.out.println(a);
        System.out.println(st);
        int x = st.pop();
        System.out.println(x);
        st.pop();
        st.peek();

    }
}
