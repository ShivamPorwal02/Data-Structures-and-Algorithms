package RecursionAV;

import java.util.Scanner;
import java.util.Stack;

public class SortAnStack {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(scn.nextInt());
        }
        SortStack(st);
        System.out.println(st);
    }
    public static void SortStack(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int val = st.pop();
        SortStack(st);
        insertinStack(st,val);
    }
    public static void insertinStack(Stack<Integer> st,int temp){
        if(st.size()==0 || st.peek()<=temp){
            st.push(temp);
            return;
        }
        int val = st.pop();
        insertinStack(st,temp);
        st.push(val);
    }
}
