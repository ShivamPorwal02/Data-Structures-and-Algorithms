package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class SmallestNumberFollowingPattern {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<Integer> st = new Stack<>();
        int num= 1;
        for (int i=0;i<s.length() ;i++ ) {
            char ch = s.charAt(i);
            if(ch=='d'){
                st.push(num);
                num++;
            }
            else{
                st.push(num);
                num++;
                while (st.size()>0){
                    System.out.print(st.pop()+" ");
                }
            }
        }
        st.push(num);
        while (st.size()>0){
            System.out.print(st.pop()+" ");
        }
    }
}
