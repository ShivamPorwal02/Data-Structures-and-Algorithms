package LoveBabbar.StackandQueues;

import java.util.Stack;

public class NextSmallerElement {
    public static long[] nextSmallerElement_(long[] arr, int n)
    {
    Stack<Integer> st = new Stack<>();
    long[] ans = new long[n];

        st.push(0);
        for(int i=1;i<arr.length;i++){
        while(st.size()>0 && arr[st.peek()]>arr[i]){
            ans[st.pop()] = arr[i];
        }
        st.push(i);

    }
    while(st.size()!=0){
        ans[st.pop()] = -1;
    }

        return ans;
}
}
