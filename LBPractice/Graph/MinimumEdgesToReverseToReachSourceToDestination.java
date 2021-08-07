package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumEdgesToReverseToReachSourceToDestination {
    static class Pair{
        int v;
        int dist;
        Pair(int v,int dist){
            this.v = v;
            this.dist = dist;
        }
    }
    public static int count(int[][] edges,int n,int src,int dest){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<n;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],0));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],1)); // ye apni edge bnadi with weight 1
        }
        // isk baad normal dikshtra
        int[] dist = new int[n];
        for (int i=0;i<n;i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));

        while(pq.size()>0){
            Pair rem = pq.remove();

            for(Pair x : adj.get(rem.v)){
                if(dist[rem.v]+x.dist < dist[x.v]){
                    dist[x.v] = dist[rem.v]+x.dist;
                    pq.add(new Pair(x.v,x.dist));
                }
            }
        }
        return dist[dest];
    }
}
