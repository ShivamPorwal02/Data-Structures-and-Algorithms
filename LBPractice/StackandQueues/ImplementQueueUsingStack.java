package LoveBabbar.StackandQueues;

import java.util.Stack;

public class ImplementQueueUsingStack {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int a)
    {
        // Your code here
        if(s1.size()==0){
            while(s2.size()>0){
                s1.push(s2.pop());
            }
            s2.push(a);
            while(s1.size()>0){
                s2.push(s1.pop());
            }
        }else{
            while(s1.size()>0){
                s2.push(s1.pop());
            }
            s1.push(a);
            while(s2.size()>0){
                s1.push(s2.pop());
            }
        }
    }
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        // Your code here
        if(s1.size() == 0 && s2.size()==0) return -1;
        else if(s1.size()!=0) return s1.pop();
        else return s2.pop();
    }

    // method 2

    //Function to push an element in queue by using 2 stacks.
    void Push_(int a)
    {
        // Your code here
        s1.push(a);
    }


    //Function to pop an element from queue by using 2 stacks.
    int Pop_()
    {
        // Your code here
        if(s1.size() == 0 && s2.size()==0) return -1;

        while(s1.size()>0){
            s2.push(s1.pop());
        }
        int ans = s2.pop();
        while(s2.size()>0){
            s1.push(s2.pop());
        }
        return ans;
    }
}
