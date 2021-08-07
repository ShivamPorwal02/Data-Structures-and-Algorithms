package LoveBabbar.StackandQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    //Function to push an element into stack using two queues.
    void push(int a)
    {
        // Your code here
        if(q1.size()==0){
            q1.add(a);
            while(q2.size()>0){
                q1.add(q2.remove());
            }
        }else{
            q2.add(a);
            while(q1.size()>0){
                q2.add(q1.remove());
            }
        }
    }

    //Function to pop an element from stack using two queues.
    int pop()
    {
        // Your code here
        if(q1.size() == 0 && q2.size()==0) return -1;
        else if(q1.size()!=0) return q1.remove();
        else return q2.remove();
    }
}
