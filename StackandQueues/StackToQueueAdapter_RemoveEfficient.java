package StackandQueues;

import java.io.BufferedReader;
import java.util.Stack;
import java.io.InputStreamReader;

public class StackToQueueAdapter_RemoveEfficient {
    public static class StackToQueueAdapter{
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter(){
            mainS = new Stack<>();
            helperS =  new Stack<>();
        }
        int size(){
            return mainS.size();
        }
        void add(int val){
            if(mainS.size()==0){
                mainS.push(val);
            }
            else{
                while(!mainS.isEmpty()){
                    helperS.push(mainS.pop());
                }
                helperS.push(val);
                while (!helperS.isEmpty()){
                    mainS.push(helperS.pop());
                }
            }
        }
        int remove(){
            if(size()==0){
                System.out.println("Queue underflow");
                return -1;
            }
            else{
                return mainS.pop();
            }

        }
        int peek(){
            if(size()==0){
                System.out.println("Queue underflow");
                return -1;
            }
            else{
                return mainS.peek();
            }
        }
    }
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }

    }
