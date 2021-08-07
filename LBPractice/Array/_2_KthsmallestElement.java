package LoveBabbar;


import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _2_KthsmallestElement {
    public static void main(String[] a){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(arr[i]);
            }else{
                if(pq.peek()>arr[i]){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        System.out.println(pq.peek());
    }
}
