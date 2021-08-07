package LoveBabbar.StackandQueues;

import java.util.Stack;

public class EvaluationofPostFixExpression {
    public static int evaluatePostFix(String s)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c == '*' || c == '/' || c=='+' || c=='-'){
                int a = st.pop();
                int b = st.pop();
                if(c== '*'){
                    st.push(b*a);
                }else if(c=='/'){
                    st.push(b/a);
                }else if(c == '+'){
                    st.push(b+a);
                }else{
                    st.push(b-a);
                }
            }
            else{
                st.push(Integer.parseInt(c+""));
            }

        }
        return st.peek();
    }
}
