package LoveBabbar.StackandQueues;

import java.util.Stack;

public class BasicCalculator_II {

    // https://www.youtube.com/watch?v=VZkc18pOCkY
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        char prevSign = '+';
        int num = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num* 10 + (c - '0');
            }
            if(isOperator(c) || i == s.length()-1){
                if(prevSign=='+'){
                    st.push(num);
                }else if(prevSign=='-'){
                    st.push(-num);
                }else if(prevSign=='*'){
                    int top = st.pop();
                    st.push(top*num);
                }else if(prevSign=='/'){
                    int top = st.pop();
                    st.push(top/num);
                }
                num = 0;
                prevSign = c;
            }
        }
        int ans = 0;
        while(st.size()>0){
            ans+=st.pop();
        }
        return ans;
    }
    public boolean isOperator(char c){
        return c == '+' || c == '*' || c== '/' || c == '-';
    }
}
