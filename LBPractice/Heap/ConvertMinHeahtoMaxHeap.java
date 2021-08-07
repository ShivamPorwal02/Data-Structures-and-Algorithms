package LoveBabbar.Heap;

public class ConvertMinHeahtoMaxHeap {
    static void Maxheapify(int[] arr,int i,int n){
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int largest = i;
        if(leftChild<n && arr[leftChild]>arr[largest]) largest = leftChild;
        if(rightChild<n && arr[rightChild]>arr[largest]) largest = rightChild;
        if(largest!=i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            Maxheapify(arr,largest,n);
        }
    }
    static void convertMaxHeap(int[] arr,int n){
        // n/2-1 islia bcz that is the last non leaf node
        for(int i=(n/2)-1;i>=0;i--){
            Maxheapify(arr,i,n);
        }
    }
}
