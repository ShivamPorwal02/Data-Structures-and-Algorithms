package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<Character> st = new Stack<>();
        System.out.println(s.length());
        for (int i = 0;i<s.length() ;i++ ) {

            if((s.charAt(i))==')'){
                if(st.peek()=='('){
                    System.out.println("true");
                    return;
                }
                else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        System.out.println("false");
    }
}
