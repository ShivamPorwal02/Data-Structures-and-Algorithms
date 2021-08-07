package LoveBabbar.StackandQueues;

import java.util.Stack;

public class MininStackinO_1andO_1Space {
    long min;
    Stack<Long> st;
    public MininStackinO_1andO_1Space() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        long value = (long)val;
        if(st.size()==0){
            st.push(value);
            min = val;
        }else if(val>=min){
            st.push(value);
        }else{
            st.push(value+value-min);
            min = value;
        }
    }

    public void pop() {
        if(st.size()==0) return;
        else if(st.peek()>min) st.pop();
        else{
            int no =  (int)min;
            min = 2*min - st.pop();
        }
    }

    public int top() {
        if(st.size()==0){
            return -1;
        }else if(st.peek()>=min){
            long a = st.peek();
            return (int)a;
        }else{
            return (int)min;
        }
    }

    public int getMin() {
        return (int)min;
    }
}
