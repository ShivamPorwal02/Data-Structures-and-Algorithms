package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluation {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String s =  scn.nextLine();

        Stack<String> postfix = new Stack<>();
        Stack<String> infix =  new Stack<>();
        Stack<Integer> ans = new Stack<>();

        for (int i = s.length()-1;i>=0 ;i-- ) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                postfix.push(ch+"");
                infix.push(ch+"");
                ans.push(Integer.parseInt(ch+""));
            }
            else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
                String pval1 = postfix.pop();
                String pval2 = postfix.pop();
                postfix.push(pval1+pval2+ch);

                String val1 = infix.pop();
                String val2 = infix.pop();
                infix.push("("+val1+ch+val2+")");

                int v1 = ans.pop();
                int v2 = ans.pop();
                int val= value(v1,v2,ch);
                ans.push(val);
            }
        }
        System.out.println(ans.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
    }
    public static int value(int v1, int v2, char ch) {
        if (ch == '+') {
            return v1 + v2;
        } else if (ch == '-') {
            return v1 - v2;
        } else if (ch == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
