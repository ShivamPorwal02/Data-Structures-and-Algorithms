package LoveBabbar.StackandQueues;

import java.util.Stack;

public class StackPermutations_ValidStackSequences_946_Leetcode {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            if(pushed[i]==popped[j]){
                while(st.size() > 0  && st.peek()==popped[j]){
                    st.pop();
                    j++;
                }
            }
        }
        return st.size()==0;
    }
}
