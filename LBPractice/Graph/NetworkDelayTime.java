package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    static class Pair{
        int v;
        int dist;
        Pair(int v,int dist){
            this.v = v;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        int[] dist = new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.dist-b.dist);

        dist[k] = 0;
        pq.add(new Pair(k,0));

        while(pq.size()>0){
            Pair rem = pq.remove();

            for(Pair x : adj.get(rem.v)){
                if(dist[rem.v]+x.dist<dist[x.v]){
                    dist[x.v] = dist[rem.v]+x.dist;
                    pq.add(new Pair(x.v,dist[x.v]));
                }
            }
        }
        int max = 0;
        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            else if(dist[i]>max) max = dist[i];
        }
        return max;
    }
}
