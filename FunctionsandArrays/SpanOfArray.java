import java.util.Scanner;

public class SpanOfArray {
    public static int SpanOfArr(int[] arr,int n){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<n ;i++ ) {
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println(max+" "+min);
        return max-min;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int span = SpanOfArr(arr,n);
        System.out.println(span);
    }
}
