package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinUndirectedGraphwithUnitWeights {
    public void shortestPath(ArrayList<ArrayList<Integer>> adj,int n,int src){
        int[] dist = new int[n];
        for (int i=0;i<n ;i++ ) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);

        while(q.size()>0){
            int rem = q.remove();

            for(int x : adj.get(rem)){
                if(dist[rem]+1>dist[x]){
                    dist[x] = dist[rem]+1;
                    q.add(x);
                }
            }
        }
        for (int i=0;i<n ;i++ ) {
            System.out.println(dist[i]+" ");
        }
    }
}
