package LoveBabbar.StackandQueues;

public class DesignCircularQueue {
    int[] arr;
    int front ;
    int size;
    int rear;
    public DesignCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        size = 0;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if(size==arr.length) return false;
        arr[(front+size)%arr.length] = value;
        size++;
        rear = ((rear+1)%arr.length);
        return true;
    }

    public boolean deQueue() {
        if(size==0) return false;
        // int temp = arr[front];
        front = ((front+1) % arr.length);
        size--;
        return true;
    }

    public int Front() {
        if(size==0) return -1;
        return arr[front];
    }

    public int Rear() {
        if(size==0) return -1;
        int temp = arr[rear];
        return temp;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==arr.length;
    }
}
