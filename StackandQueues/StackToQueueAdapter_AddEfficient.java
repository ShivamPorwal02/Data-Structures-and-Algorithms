package StackandQueues;

import java.util.Stack;

public class StackToQueueAdapter_AddEfficient {
    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int remove() {
            // write your code here
            if(mainS.size()==0){
                System.out.println("Queue underflow");
                return -1;
            }
            while(mainS.size()!=1){
                helperS.push(mainS.pop());
            }
            int val = mainS.pop();
            while (helperS.size()!=0) {
                mainS.push(helperS.pop());
            }
            return val;
        }

        int peek() {
            if(mainS.size()==0){
                System.out.println("Queue underflow");
                return -1;
            }
            while(mainS.size()!=1){
                helperS.push(mainS.pop());
            }
            int val = mainS.pop();
            helperS.push(val);
            while (helperS.size()!=0) {
                mainS.push(helperS.pop());
            }
            return val;
        }
    }
}
