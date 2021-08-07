package TimeandSpaceComplexity;
import java.util.Scanner;

public class PivotSortedRotatedArray {
    public static int findPivot(int[] arr) {
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int mid = (i+j)/2;
            if(arr[mid]>arr[j]){
                i=mid+1;
            } else{
                j=mid;
            }
        }
        return arr[j];
    }

//    int i=0;
//    int j=arr.length-1;
//        while(i<j){
//        int idx = (i+j)/2;
//        if(arr[idx]>arr[j]){
//            i=idx;
//        }
//        else if(arr[idx]<arr[i] && arr[idx]<arr[j] && arr[idx]<arr[idx+1] && arr[idx] <arr[idx-1]){
//            return arr[idx];
//        }
//        else{
//            j=idx;
//        }
//
//    }
//        return 0;


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
    }
}
