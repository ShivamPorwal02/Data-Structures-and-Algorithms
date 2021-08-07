package LoveBabbar.StackandQueues;

import java.util.Stack;

public class ValidSubstring_LongestValiParatheses_32_Leetcode {
    public int longestValidParentheses(String s) {
        if(s=="") return 0;
        Stack<Character> st = new Stack<>();
        Stack<Integer> problemIndex = new Stack<>();
        problemIndex.push(-1);
        int max = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push('(');
                problemIndex.push(i);
            }else{
                if(st.size()>0 && st.peek()=='('){
                    st.pop();
                    problemIndex.pop();
                    max = Math.max(max,i-problemIndex.peek());

                }else{
                    problemIndex.push(i);
                }
            }
        }
        return max;
    }
}
