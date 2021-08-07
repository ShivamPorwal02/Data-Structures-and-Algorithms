package RecursionAV;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStackusingRecursion {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(scn.nextInt());
        }
        StackReverse(st);
        System.out.println(st);
    }
    public static void StackReverse(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int top = st.pop();
        StackReverse(st);
        addatLast(st,top);
    }
    public static void addatLast(Stack<Integer> st,int temp){
        if(st.size()==0){
            st.push(temp);
            return;
        }
        int top = st.pop();
        addatLast(st,temp);
        st.push(top);
    }
}
