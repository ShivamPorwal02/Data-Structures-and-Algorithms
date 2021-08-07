package LoveBabbar.StackandQueues;

import java.util.Stack;

public class ExpressionContainsRedundantBracketorNot {
        public static void main(String[] args) {
            String s = "(a+(b)/c)";
            System.out.println(isRedundant(s));
        }
        public static boolean isRedundant(String s){
            Stack<Character> st = new Stack<>();

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==')'){
                    int cnt = 0;
                    while(st.size()>0 && st.peek()!='('){
                        char c = st.pop();
                        if(isOperator(c)) cnt++;

                    }
                    st.pop();
                    if(cnt==0) return true;
                }else{
                    st.push(s.charAt(i));
                }
            }
            return false;
        }
        public static boolean isOperator(char c){
            return c == '*' || c == '/' || c == '-' || c == '+';
        }
    }

