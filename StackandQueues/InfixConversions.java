package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class InfixConversions {
    public static void main(String[] arr) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        Stack<Character> oprtr = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                oprtr.push(ch);
            }else if(ch==')') {
                while (oprtr.peek() != '(') {
                    char opr = oprtr.pop();

                    String v2 = postfix.pop();
                    String v1 = postfix.pop();
                    String val = v1+v2+opr;
                    postfix.push(val);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String pval = opr+prev1+prev2;
                    prefix.push(pval);
                }
                oprtr.pop();
            }
            else if((ch>='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A' && ch<='B')){
                    // string bnane k chr+"" ye krdo
                postfix.push(ch+"");
                prefix.push(ch+"");

            }
            else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
                while(oprtr.size()>0 && oprtr.peek()!='(' && precedence(ch)<=precedence(oprtr.peek())){
                    char opr = oprtr.pop();

                    String v2 = postfix.pop();
                    String v1 = postfix.pop();
                    String val = v1+v2+opr;
                    postfix.push(val);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String pval = opr+prev1+prev2;
                    prefix.push(pval);
                }
                oprtr.push(ch);
            }
        }
        while(oprtr.size()>0){
            char opr = oprtr.pop();

            String v2 = postfix.pop();
            String v1 = postfix.pop();
            String val = v1+v2+opr;
            postfix.push(val);

            String prev2 = prefix.pop();
            String prev1 = prefix.pop();
            String pval = opr+prev1+prev2;
            prefix.push(pval);
        }
        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }
    public static int precedence(char ch){
        if(ch=='+'){
            return 1;
        }else if(ch=='-'){
            return 1;
        }else if(ch=='/'){
            return 2;
        }
        else {
            return 2;
        }
    }
}
