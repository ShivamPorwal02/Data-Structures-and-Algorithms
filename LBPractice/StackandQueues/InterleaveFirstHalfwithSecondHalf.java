package LoveBabbar.StackandQueues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class InterleaveFirstHalfwithSecondHalf {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);

        interleave(q);
        System.out.println(q);
    }

    public static void interleave(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        int cnt = 0;
        int n = q.size() / 2;

        for (int i = 0; i < n; i++) {
            st.push(q.remove());
        }

        while (st.size() > 0) {
            q.add(st.pop());
        }

        for(int i=0;i<n;i++){
            q.add(q.remove());
        }

        for (int i = 0; i < n; i++) {
            st.push(q.remove());
        }

        while(st.size()>0){
            q.add(st.pop());
            q.add(q.remove());
        }
    }
}
