package LoveBabbar;

public class ThreeWayPartitioning {
    public void threeWayPartition(int array[], int a, int b)
    {
        // code here

        int current=0,left=0,right=array.length-1;

        while(current<=right)
        {
            if(array[current]<a)
            {
                swap(array,left,current);
                current++;
                left++;
            }

            else if(array[current]>b)
            {
                swap(array,current,right);
                right--;
            }
            else //i.e. the number is within [a,b]
            {
                current++;
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
}
