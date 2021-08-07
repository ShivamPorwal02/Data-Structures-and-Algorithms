package RecursionAV;


import java.util.Scanner;
import java.util.Stack;

public class DeleteMiddleElementFromStack {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<n ;i++ ) {
            st.push(scn.nextInt());
        }
        Stack<Integer> nSt  = DeleteMid(st,n);
        System.out.println(nSt);
    }
    public static Stack<Integer> DeleteMid(Stack<Integer> st,int size){
        if(size==0){
            return st;
        }
        int mid = size/2+1;
        remove(st,mid);
        return st;
    }
    public static void remove(Stack<Integer> st,int k){
        if(k==1){
            st.pop();
            return;
        }
        int top = st.pop();
        remove(st,k-1);
        st.push(top);
    }
    // sahi print hora hao stack m kaise dlega vaise socho..
}
