package LoveBabbar.StackandQueues;

public class ImplementCircularQueue {
    public class CircularQueue{
        int[] arr;
        int front ;
        int size ;
        CircularQueue(int n){
            arr = new int[n];
            front = 0;
            size = 0;
        }
        public void add(int a){
            if(size==arr.length) return;
            arr[(front+size)%arr.length] = a;
            size++;
        }
        public int size(){
            return size;
        }
        public int remove(){
            int temp = arr[front];
            front = (front % arr.length)+1;
            size--;
            return temp;
        }
        public int peek(){
            if(size==0) return -1;
            return arr[front];

        }
        public void display(){
            if(size==0) return;
            for(int i = 0 ; i<size;i++){
                System.out.println(arr[(i+front)%arr.length]);
            }
        }
    }
}
