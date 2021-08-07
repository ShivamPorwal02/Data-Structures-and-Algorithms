package LoveBabbar.StackandQueues;

import java.util.Stack;

    public class InfixToPrefix {
        public static void main(String[] args) {
            String s = "(A-B/C)*(A/K-L)";
            String str = reverseString(s);
            String ans = infixToPostfix(str);
            String Ans = reverseString(ans);
            System.out.println(Ans);
        }
        public static String reverseString(String s) {
            String rev = "";
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i)==')'){
                    rev+='(';
                }else if(s.charAt(i)=='('){
                    rev+=')';
                }else{
                    rev+=s.charAt(i);
                }
            }
            return rev;
        }

        public static String infixToPostfix(String s) {
            // Your code here

            Stack<Character> st = new Stack<>();

            String res = "";

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    res += s.charAt(i);
                } else if (s.charAt(i) == '(') {
                    st.push('(');
                } else if (s.charAt(i) == ')') {
                    while (st.size() > 0 && st.peek() != '(') {
                        res += st.pop();
                    }
                    st.pop();
                } else {
                    while (st.size() > 0 && precedence(st.peek()) >= precedence(s.charAt(i))) {
                        res += st.pop();
                    }
                    st.push(s.charAt(i));
                }
            }

            while (st.size() != 0) {
                res += st.pop();
            }
            return res;

        }

        public static int precedence(char c) {
            if (c == '^') return 3;
            else if (c == '*' || c == '/') return 2;
            else if (c == '+' || c == '-') return 1;
            else return -1;
        }
    }
