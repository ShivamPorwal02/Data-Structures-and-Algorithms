package LoveBabbar.StackandQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SumofMinimumMaximumofSizeK {
    public static int sumofMaxMin(int[] arr,int k){
        int size = arr.length;

        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int idx = 0;
        int[] ans1 = new int[arr.length-k+1];
        int[] ans2 = new int[arr.length-k+1];
        while(j<size){
            while(q1.size()>0 && q1.peekLast()<arr[j]) q1.removeLast();
            q1.add(arr[j]);
            while(q2.size()>0 && q2.peekLast()>arr[j]) q2.removeLast();
            q2.add(arr[j]);

            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                ans1[idx] = q1.peek();
                ans2[idx] = q2.peek();
                if(arr[i]==q1.peek()) q1.remove();
                if(arr[i]==q2.peek()) q2.remove();
                i++;
                j++;
                idx++;
            }
        }
        int sum = 0;
        for(i = 0 ;i <ans1.length;i++){
            sum+=(ans1[i]+ans2[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int ans = sumofMaxMin(arr,k);
        System.out.println(ans);
    }
}
