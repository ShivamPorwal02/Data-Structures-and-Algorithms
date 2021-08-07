package LoveBabbar.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kthLargestSumContinuousSubarray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<n ;i++ ) {
            int sum =0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                pq.add(sum);
            }
        }
//        System.out.println(pq);
        int ans = 0;
        while(k!=0){
            ans = pq.remove();
            k--;
        }
        System.out.println(ans);
    }

    // ye acha hai
    static int kthLargestSum(int arr[], int n, int k) {
        // array to store predix sums
        int sum[] = new int[n + 1];
        sum[0] = 0;
        sum[1] = arr[0];
        for (int i = 2; i <= n; i++)
            sum[i] = sum[i - 1] + arr[i - 1];

        // priority_queue of min heap
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();

        // loop to calculate the contiguous subarray
        // sum position-wise
        for (int i = 1; i <= n; i++) {

            // loop to traverse all positions that
            // form contiguous subarray
            for (int j = i; j <= n; j++) {
                // calculates the contiguous subarray
                // sum from j to i index
                int x = sum[j] - sum[i - 1];

                // if queue has less then k elements,
                // then simply push it
                if (Q.size() < k)
                    Q.add(x);

                else {
                    // it the min heap has equal to
                    // k elements then just check
                    // if the largest kth element is
                    // smaller than x then insert
                    // else its of no use
                    if (Q.peek() < x) {
                        Q.poll();
                        Q.add(x);
                    }
                }
            }
        }
        return Q.poll();
    }
}
