package LoveBabbar.Strings;

import java.util.Stack;

public class CountTheReversal {
    int countRev (String s)
    {
        // your code here
        if(s.length()%2!=0){
            return -1;
        }
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='}' && st.size()==0){
                cnt+=1;
                st.add('{');
            }else if(st.size()>0 && s.charAt(i)=='}' && st.peek()=='{'){
                st.pop();
            }else{
                st.add(s.charAt(i));
            }
        }
        cnt = cnt+st.size()/2;
        return cnt;
    }
}
