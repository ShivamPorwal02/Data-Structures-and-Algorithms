package LoveBabbar.StackandQueues;

import java.util.Stack;

public class ReverseAStackusingRecursion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }
    public static void reverseStack(Stack<Integer> st){
        if(st.size()==0) return;

        int temp = st.pop();
        reverseStack(st);
        insert_at_last(st,temp);
    }
    public static void insert_at_last(Stack<Integer> st,int ele){
        if(st.size()==0){
            st.push(ele);
            return;
        }
        int temp = st.pop();
        insert_at_last(st,ele);
        st.push(temp);
    }
}
