package LoveBabbar.StackandQueues;

public class ImplementStack {
    public class dynamicStack {
        int[] data;
//        int top;
        int size;

        public dynamicStack(int cap) {
            data = new int[cap];
//            top = -1;
            size = 0;
        }

        int size() {
            // write ur code here
            return size;
        }

        void display() {
            for (int i = size - 1; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            if (size == data.length) {
//                System.out.println("Stack Overflow");  //yhi tk hota agr normal stack bnani hoti
                int oldlength = data.length;
                int[] newdata = new int[2*oldlength];
                for (int i=0;i<oldlength;i++ ) {
                    newdata[i] = data[i];
                }
                data = newdata;
            }
            data[size] = val;
            size++;
        }

        int pop() {
            // write ur code here
            if (size == 0) {
                System.out.println("UnderFlow Error");
                return -1;
            }
            int pop = data[size-1];
            size--;
            return pop;

        }

        int top() {
            if (size == 0) {
                System.out.println("UnderFlow Error");
                return -1;
            }
            return data[size-1];
        }
    }
}
