package LoveBabbar.StackandQueues;

public class ImplementQueue {
    public class DynaminQueue {
        int[] data;
        int size;
        int front;

        DynaminQueue(int cap) {
            data = new int[cap];
            size = 0;
            front = 0;
        }

        int size() {
            // write ur code here
            return size;
        }

        void display() {
            // write ur code here
            for (int i = 0;i<size ;i++ ) {
                System.out.println(data[(i+front)%data.length]+ " ");
            }
            System.out.println();
        }
        void add(int val) {

            //addition rear pr hoga rear = front+size

            if(size==data.length){
//                System.out.println("Overflow Error");
                int[] ndata = new int[2*data.length];
                for(int i=0;i<size;i++){
                    ndata[i]=data[(i+front)%data.length];
                }
                data = ndata;
                front = 0;
            }
            // write ur code here
            int rear = (front+size)%data.length;
            data[rear] = val;
            size++;
        }

        int remove() {
            // write ur code here
            if(size==0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int val = data[front];
            front = ((front+1)% data.length);
            size--;
            return val;
        }

        int peek() {
            // write ur code here
            if(size==0){
                System.out.println("Queue Underflow");
                return -1;
            }
            return data[front];
        }
    }
}
