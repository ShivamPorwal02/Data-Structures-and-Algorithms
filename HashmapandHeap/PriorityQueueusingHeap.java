package HashmapandHeap;

import java.util.ArrayList;
import java.util.LinkedList;

public class PriorityQueueusingHeap {
    public static class PriorityQueueUsingHeap{
        ArrayList<Integer> data;

        PriorityQueueUsingHeap(){
            data = new ArrayList<>();
        }
        public void add(int val){
            data.add(val);
            upheapify(data.size()-1);
        }
        private void upheapify(int i){
            int pi = (i-1)/2;
            if(data.get(pi)>data.get(i)){
                swap(i,pi);
                upheapify(pi);
            }

        }
        public int remove(){
            if(this.size()==0) {
                System.out.println("Underflow");
                return -1;
            }
            swap(0,data.size()-1);
            int val = data.remove(data.size()-1);
            downheapify(0);
            return val;
        }
        private void downheapify(int pi){
            int mini = pi;
            int li = 2*pi+1;
            if(li<data.size() && data.get(pi)<data.get(mini)){
                mini = li;
            }
            int ri = 2*pi+2;
            if(ri<data.size() && data.get(pi)<data.get(mini)){
                mini = ri;
            }
            if(mini!=pi){
                swap(mini,pi);
                downheapify(mini);
            }
        }
        private void swap(int i,int j){
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i,jth);
            data.set(j,ith);
        }
        public int peek(){
            if(this.size()==0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }
        public int size(){
            return data.size();
        }
    }
}
