package LoveBabbar.StackandQueues;

import java.util.Stack;

public class ParenthesisChecker {
    static boolean ispar(String s)
    {
        // add your code here

        if(s.charAt(0)=='}' || s.charAt(0)==')' || s.charAt(0) == ']') return false;
        Stack<Character> st = new Stack<>();

        for(int i = 0 ;i<s.length();i++){
            if(st.size()>0 && s.charAt(i) == '}' && st.peek() == '{') st.pop();
            else if(st.size()>0 && s.charAt(i) == ')' && st.peek() == '(') st.pop();
            else if(st.size()>0 && s.charAt(i) == ']' && st.peek() == '[') st.pop();
            else st.push(s.charAt(i));
        }
        return st.size()==0;
    }
}
