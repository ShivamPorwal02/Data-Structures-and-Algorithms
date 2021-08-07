package LoveBabbar.StackandQueues;

import java.util.Stack;

public class NextGreaterElement_II {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        if(arr.length==1){
            ans[0] = -1;
            return ans;
        }
        st.push(0);
        int i = 1;
        boolean flag = false;
        while(i!=st.peek()){
            while(st.size()>0 && arr[st.peek()]<arr[i]){
                ans[st.pop()] = arr[i];
            }
            if(flag==false) st.push(i);
            i++;
            if(i==arr.length) {
                i = 0;
                flag = true;
            }
        }

        while(st.size()!=0){
            ans[st.pop()] = -1;
        }

        return ans;
    }
}
