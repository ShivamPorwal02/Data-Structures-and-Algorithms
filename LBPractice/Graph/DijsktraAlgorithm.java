package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijsktraAlgorithm {
    static class Pair{
        int v;
        int dist;
        Pair(int v,int dist){
            this.v = v;
            this.dist = dist;
        }
    }

    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        // Write your code here
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.dist-b.dist);

        dist[s] = 0;
        pq.add(new Pair(s,0));

        while(pq.size()>0){
            Pair rem = pq.remove();

            for(ArrayList<Integer> x : adj.get(rem.v)){
                if(dist[rem.v]+x.get(1)<dist[x.get(0)]){
                    dist[x.get(0)] = dist[rem.v]+x.get(1);
                    pq.add(new Pair(x.get(0),x.get(1)));
                }
            }
        }
        return dist;

    }
}
