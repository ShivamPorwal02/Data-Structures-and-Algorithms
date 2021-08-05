package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluationsandConversions {
    public static void main(String[] arr) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> ans = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                infix.push(ch + "");
                prefix.push(ch + "");
                ans.push(Integer.parseInt(ch+""));
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String val2 = infix.pop();
                String val1 = infix.pop();
                String val = "(" + val1 + ch + val2 + ")";
                infix.push(val);

                String pval2 = prefix.pop();
                String pval1 = prefix.pop();
                String pval = ch + pval1 + pval2;
                prefix.push(pval);

                int v2 = ans.pop();
                int v1 = ans.pop();
                int bval = value(v1, v2, ch);
                ans.push(bval);
            }
        }
        System.out.println(prefix.peek());
        System.out.println(infix.peek());
        System.out.println(ans.peek());
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
