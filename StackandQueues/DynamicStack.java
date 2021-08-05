package StackandQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DynamicStack {
        int[] data;
        int tos;

        public DynamicStack(int cap){
            data = new int[cap];
            tos = -1;
        }
        int size(){
            return tos+1;
        }
        void display(){
            for (int i=tos;i>=0 ;i-- ) {
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }
        void push(int val){
            if(this.size()<data.length) {
                tos++;
                data[tos] = val;
            }else{
                int[] ndata = new int[2*data.length];
                for(int i=0;i<data.length;i++){
                    ndata[i] = data[i];
                }
                tos++;
                ndata[tos] = val;

                data = ndata;

            }
        }
        int pop() {
            if (this.size() != 0) {
                tos--;
                return data[tos + 1];
            }else{
                System.out.println("Stack underflow");
                return -1;
            }
        }
        int top(){
            if(this.size()!=0) {
                return data[tos];
            }else{
                System.out.println("Stack underflow");
                return -1;
            }
        }
    public static void main(String[] arr) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        DynamicStack st = new DynamicStack(n);

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(st.size());
            } else if(str.startsWith("display")){
                st.display();
            }
            str = br.readLine();
        }
    }
}
