package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {
    class Pair{
        int v;
        double dist;
        Pair(int v,double dist){
            this.v = v;
            this.dist = dist;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }

        double[] dist = new double[n];
        for(int i=0;i<n;i++){
            dist[i] = -10;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Double.compare(b.dist,a.dist));

        dist[start] = 1;
        pq.add(new Pair(start,1));

        while(pq.size()>0){
            Pair rem = pq.remove();

            for(Pair x : adj.get(rem.v)){

                if((double)dist[rem.v]*(double)x.dist>dist[x.v]){
                    dist[x.v] = (double)dist[rem.v]*(double)x.dist;
                    pq.add(new Pair(x.v,dist[x.v]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        return dist[end]<0 ? 0 : dist[end];

    }
}
