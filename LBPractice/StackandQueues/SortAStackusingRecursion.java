package LoveBabbar.StackandQueues;

import java.util.Stack;

public class SortAStackusingRecursion {
    public Stack<Integer> sort(Stack<Integer> s)
    {
        //add code here.
        sort1(s);
        return s;
    }
    public void sort1(Stack<Integer> st){
        if(st.size()==0) return ;

        int temp = st.pop();
        sort1(st);
        insertAtRightPlace(st,temp);
    }
    public void insertAtRightPlace(Stack<Integer> st,int temp){
        if(st.size()==0 || st.peek()<temp) {
            st.push(temp);
            return;
        }
        int tp = st.pop();
        insertAtRightPlace(st,temp);
        st.push(tp);
    }
}
