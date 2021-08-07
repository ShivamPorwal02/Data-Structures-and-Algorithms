package LoveBabbar.StackandQueues;

import java.util.Queue;

public class ReverseQueue {
    public Queue<Integer> rev(Queue<Integer> q){
        //add code here.
        reverse(q);
        return q;
    }
    public void reverse(Queue<Integer> q){
        if(q.size()==0) return;

        int temp = q.remove();
        reverse(q);
        q.add(temp);
    }
}
