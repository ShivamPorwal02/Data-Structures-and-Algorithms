package LoveBabbar.StackandQueues;

import java.util.Stack;

public class DeleteMidElementofStack {
    public void deleteMid(Stack<Integer> s, int sizeOfStack){
        // code here
        int mid = (int)Math.ceil(sizeOfStack/2);
        recurr(s,mid);
    }
    public void recurr(Stack<Integer> st,int mid){
        if(st.size()==0) return;

        int data = st.pop();
        recurr(st,mid-1);
        if(mid!=0) st.push(data);
    }
}
