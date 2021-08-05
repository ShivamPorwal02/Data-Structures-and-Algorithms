package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        Stack<Integer> oprds = new Stack<>();
        Stack<Character> oprtr = new Stack<>();

        for (int i=0;i<s.length() ;i++ ) {
            char ch = s.charAt(i);
            if(ch=='('){
                oprtr.push(ch);
            }else if(ch==')') {
                while (oprtr.peek() != '(') {
                    int v2 = oprds.pop();
                    int v1 = oprds.pop();
                    char opr = oprtr.pop();
                    int val = value(v1, v2, opr);
                    oprds.push(val);
                }
                oprtr.pop();
            }else if(Character.isDigit(ch)) {
                oprds.push(ch-'0');
            }else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
                while(oprtr.size()>0 && oprtr.peek()!='(' && precedence(ch)<=precedence(oprtr.peek())){
                    int v2 = oprds.pop();
                    int v1 = oprds.pop();
                    char opr = oprtr.pop();
                    int val = value(v1, v2, opr);
                    oprds.push(val);
                }
                oprtr.push(ch);
            }
        }
        while(oprtr.size()>0){
            int v2 = oprds.pop();
            int v1 = oprds.pop();
            char opr = oprtr.pop();
            int val = value(v1, v2, opr);
            oprds.push(val);
        }
        System.out.println(oprds.peek());
    }
    public static int precedence(char ch){
        if(ch=='+'){
            return 1;
        }else if(ch == '-'){
            return 1;
        }else if(ch=='*'){
            return 2;
        }else {
            return 2;
        }
    }
    public static int value(int v1,int v2,char ch){
        if(ch=='+'){
            return v1+v2;
        }else if(ch == '-'){
            return v1-v2;
        }else if(ch=='*'){
            return v1*v2;
        }else {
            return v1/v2;
        }
    }
}
