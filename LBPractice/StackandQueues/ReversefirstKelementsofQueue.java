package LoveBabbar.StackandQueues;

import java.util.Queue;

public class ReversefirstKelementsofQueue {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        //add code here.
        kreverse(q,k);
        int x = q.size()-k;
        while(x!=0){
            q.add(q.remove());
            x--;
        }
        return q;
    }
    public void kreverse(Queue<Integer> q,int k){
        if(q.size()==0 || k==0) return;

        int temp = q.remove();
        kreverse(q,k-1);
        q.add(temp);
    }
}
