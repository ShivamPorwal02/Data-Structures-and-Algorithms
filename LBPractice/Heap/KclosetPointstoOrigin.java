package LoveBabbar.Heap;

import java.util.PriorityQueue;

public class KclosetPointstoOrigin {
    class Pair{
        int[] arr;
        int dist;
        Pair(int[] arr,int dist){
            this.arr =  arr;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->b.dist-a.dist);

        for(int[] arr : points){
            if(pq.size()<k) pq.add(new Pair(arr,arr[0]*arr[0]+arr[1]*arr[1]));
            else{
                if(pq.peek().dist>arr[0]*arr[0]+arr[1]*arr[1]){
                    pq.remove();
                    pq.add(new Pair(arr,arr[0]*arr[0]+arr[1]*arr[1]));
                }
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        // System.out.println(pq.size());
        while(pq.size()>0){
            Pair rem = pq.remove();
            ans[i][0] = rem.arr[0];
            ans[i][1] = rem.arr[1];
            i++;
        }
        return ans;
    }
}

