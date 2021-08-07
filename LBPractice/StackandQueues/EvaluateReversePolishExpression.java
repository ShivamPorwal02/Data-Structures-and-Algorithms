package LoveBabbar.StackandQueues;

import java.util.Stack;

public class EvaluateReversePolishExpression {
    public int evalRPN(String[] s) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            String c = s[i];


            if (c.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b * a);
            } else if (c.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else if (c.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b + a);
            } else if (c.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else {
                st.push(Integer.parseInt(c));
            }

        }
        return st.peek();
    }
}
