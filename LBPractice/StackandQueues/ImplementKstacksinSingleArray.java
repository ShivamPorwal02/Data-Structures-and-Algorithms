package LoveBabbar.StackandQueues;

public class ImplementKstacksinSingleArray {
    static class kStack{
        int[] arr;
        int[] top;
        int[] next;
        int n;
        int k;
        int free;

        kStack(int k1,int n1){
            k = k1;
            n = n1;

            arr = new int[n];
            next = new int[n];
            top = new int[k];

            for (int i=0;i<k ;i++ ) {
                top[i] = -1;
            }
            free = 0;
            for (int i=0;i<n-1 ;i++ ) {
                next[i] = i+1;
            }
            next[n-1] = -1;
        }

        boolean isFull(){
            return free==-1;
        }
        void push(int item,int sn){
            if(isFull()){
                System.out.println("Stack Overflow");
            }
            int i = free; // Store the index first free slot

            free = next[i];

            next[i] = top[sn];
            top[sn] = i;

            arr[i] = item;
        }

        int pop(int sn){

            if (isEmpty(sn)) {
                System.out.println("Stack UnderFlow");
                return -1;
            }

            int i = top[sn];

            top[sn] = next[i];

            next[sn] = free;
            free = i;

            return arr[i];
        }
        boolean isEmpty(int sn)
        {
            return (top[sn] == -1);
        }
    }
}
