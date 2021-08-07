package LoveBabbar.Heap;

public class MergeTwoBinaryMaxHeaps {
    public void maxProfit(long merged[], long a[], long b[], long n, long m) {


        for(int i=0;i<n;i++){
            merged[i] = a[i];
        }
        for(int i=0;i<m;i++){
            merged[i+(int)n] = b[i];
        }
        for(int i=(int)(n/2)-1;i>=0;i--){
            maxHeapify(merged,i,m+n);
        }
    }
    public void maxHeapify(long[] arr, int i,long n){
        if(i>=n) return;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int largest = i;

        if(leftChild<n && arr[leftChild]>arr[largest]) largest = leftChild;
        if(rightChild<n && arr[rightChild]>arr[largest]) largest = rightChild;

        if(largest!=i){
            long temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr,largest,n);
        }
    }
}
