package DynamicProgrammingAV;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public String removeDuplicates(String s) {

        // stack solution // 136ms
        Stack<Character> st = new Stack<>();
        st.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(st.size()>0 && st.peek()==s.charAt(i)){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        String ans = "";
        while(st.size()>0){
            ans = st.pop()+ans;
        }
        return ans;

        // String builder // 6ms
//        StringBuilder sb = new StringBuilder(s);

//        for(int i=1;i<sb.length();i++){
//            if(sb.charAt(i)==sb.charAt(i-1)){
//                sb.deleteCharAt(i);
//                sb.deleteCharAt(i-1);
//                i = i-2 < 0 ? 0 : i-2;
//            }
//        }
//        return sb.toString();
    }
}
