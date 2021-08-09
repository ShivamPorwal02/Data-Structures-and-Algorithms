package LeetCode;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()) return "0";
        Stack<Character> st = new Stack<>();

        for(int i=0;i<num.length();i++){
            while(st.size()>0 && (int)st.peek()>(int)num.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        StringBuilder s = new StringBuilder();
        while(st.size()>0){
            s.append(st.pop());
        }
        String str =  s.reverse().toString();
        if(k!=0) str = str.substring(0,str.length()-k);
        int i = 0;
        while(i<str.length() && str.charAt(i)=='0'){
            i++;
        }
        if(str.substring(i).equals("")) return "0";
        return str.substring(i);
    }
}
