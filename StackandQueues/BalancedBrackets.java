package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<Character> st = new Stack<>();
        for (int i=0;i<s.length() ;i++ ) {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(!st.empty()&&st.peek()=='('){
                    st.pop();
                }
                else{
                    System.out.println("false");
                    return;
                }
            }else if(!st.empty()&&s.charAt(i)=='}') {
                if (st.peek() == '{') {
                    st.pop();
                } else {
                    System.out.println("false");
                    return;
                }
            }else if(!st.empty()&&s.charAt(i)==']') {
                if (st.peek() == '[') {
                    st.pop();
                } else {
                    System.out.println("false");
                    return;
                }
            }
            System.out.println(st);
        }
        System.out.println(st.size()==0?"true":"false");
    }
}
