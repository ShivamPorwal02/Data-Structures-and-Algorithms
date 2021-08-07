package LoveBabbar.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKsortedArray {
    static class Pair{
        int i;
        int j;
        int data;
        Pair(int data,int i,int j){
            this.data = data;
            this.i = i;
            this.j =j;

        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k)
    {
        // Write your code here.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.data-b.data);

        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i][0],i,0));
        }

        ArrayList<Integer> lst = new ArrayList<>();

        while(pq.size()>0){
            Pair rem = pq.remove();
            lst.add(rem.data);
            // System.out.println(rem.j);
            if(rem.j<k-1){
                pq.add(new Pair(arr[rem.i][rem.j+1],rem.i,rem.j+1));
            }
        }
        return lst;
    }
}
