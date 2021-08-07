package LoveBabbar.StackandQueues;

import java.util.Stack;

public class ReverseStringUsingStack {
    public String reverse(String s){
        //code here
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            st.push(c);
        }
        String ans = "";
        while(st.size()>0){
            ans+=st.pop();
        }
        return ans;
    }
}
