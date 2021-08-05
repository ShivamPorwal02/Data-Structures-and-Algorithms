package StackandQueues;

public class TwoStacksInAnArray {
    public static class TwoStack{
        int[] data;
        int tos1;
        int tos2;
        public TwoStack(int cap){
            data = new int[cap];
            tos1 = -1;
            tos2 = cap;
        }
        int size1() {
            // write your code here
            return tos1+1;
        }

        int size2() {
            // write your code here
            return data.length - tos2;
        }

        void push1(int val) {
            // write your code here
            if(size1()+size2()<data.length) {
                tos1++;
                data[tos1] = val;
            }else{
                System.out.println("Stack overflow");
            }
        }

        void push2(int val) {
            // write your code here
            if(size1()+size2()<data.length) {
                tos2--;
                data[tos2] = val;
            }else{
                System.out.println("Stack overflow");
            }
        }

        int pop1() {
            // write your code here
            if(size1()==0){
                System.out.println("Stack underflow");
                return -1;
            }else {
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2() {
            // write your code here
            if(size2()==0){
                System.out.println("Stack underflow");
                return -1;
            }
            else {
                int val = data[tos2];
                tos2++;
                return val;
            }
        }

        int top1() {
            // write your code here
            if(size1()==0){
                System.out.println("Stack underflow");
                return -1;
            }else {
                int val = data[tos1];
                return val;
            }
        }

        int top2() {
            // write your code here
            if(size2()==0){
                System.out.println("Stack underflow");
                return -1;
            }
            else {
                int val = data[tos2];
                return val;
            }
        }
    }
}
