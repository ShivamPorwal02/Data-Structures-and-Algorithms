package TimeandSpaceComplexity;
import java.util.Scanner;

public class Sort01 {
    public static void sort01(int[] arr) {
        int i=0;
        int j= arr.length-1;
        while(i<j){
            if(arr[i]==1 && arr[j]==0){
                swap(arr,i,j);
                i++;
                j--;
            }
            if(arr[j]==1){
                j--;
            }
            if(arr[i]==0) {
                i++;
            }
        }
        // partition lga dp
//                int m=0;
//        int n=0;
//        for(int i=0;i<arr.length;i++ ){
//            if(arr[m]==0){
//                swap(arr,m,n);
//                m++;
//                n++;
//            }
//            else{
//            m++;
//            }

    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort01(arr);
        print(arr);
    }
}
