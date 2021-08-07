package LoveBabbar.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
    static HashSet<String> hm1;
    public List<String> removeInvalidParentheses(String s) {
        hm1 = new HashSet<>();
        List<String> lst  = new ArrayList<>();
        HashSet<String> hm = new HashSet<>();
        int min = minRemoval(s);
        balance(s,hm,min);

        for(String rem : hm) lst.add(rem);
        return lst;
    }
    public void balance(String s, HashSet<String> hm, int removal){
        if(removal==0){
            if(isValid(s)&& !hm.contains(s)){
                hm.add(s);
            }
            return;
        }

        // these two lines of code to avoid tle
        if(hm1.contains(s)) return;
        else hm1.add(s);

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                balance(s.substring(0,i)+s.substring(i+1),hm,removal-1);
            }
        }
    }
    public int minRemoval(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.size()>0 && st.peek()=='(' && s.charAt(i)==')') st.pop();
            else if(s.charAt(i)=='(' || s.charAt(i)==')') st.push(s.charAt(i));
        }
        return st.size();
    }
    public boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.size()>0 && st.peek()=='(' && s.charAt(i)==')') st.pop();
            else if(s.charAt(i)=='(' || s.charAt(i)==')') st.push(s.charAt(i));
        }
        return st.size()==0;
    }
}
