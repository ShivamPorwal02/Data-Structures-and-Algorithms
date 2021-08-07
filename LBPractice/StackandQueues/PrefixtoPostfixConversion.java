package LoveBabbar.StackandQueues;

import java.util.Stack;

public class PrefixtoPostfixConversion {
    public static void main(String[] args) {
        String s = "*+AB-CD";
        String ans = preTopost(s);
        System.out.println(ans);
    }
    public static String preTopost(String s){
        Stack<String> st = new Stack<>();

        for(int i = s.length()-1;i>=0;i--){
            String c = s.charAt(i)+"";
            if(c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-")){
                String s1 = st.pop();
                String s2 = st.pop();

                String temp = s1+s2+c;
                st.push(temp);
            }else{
                st.push(c);
            }
        }
        return st.peek();
    }
}

//*+AB-CD
// a+b * c-d
// ab+cd-*
