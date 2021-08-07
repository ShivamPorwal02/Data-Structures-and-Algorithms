package LoveBabbar.Graph;

import java.util.ArrayList;

public class BellmanFordAlgorithm {
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> adj, int s)
    {
        // Write your code here
        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i] = 100000000;

        dist[s] = 0;

        for(int i = 0;i<n-1;i++){
            for(int j = 0 ; j< adj.size();j++){
                if(dist[adj.get(j).get(0)]+adj.get(j).get(2) < dist[adj.get(j).get(1)]){
                    dist[adj.get(j).get(1)] = dist[adj.get(j).get(0)]+adj.get(j).get(2);
                }
            }
        }
        return dist;
    }
}
