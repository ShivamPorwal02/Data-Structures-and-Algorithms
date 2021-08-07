package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class LongestPathinDAG {
    class Pair{
        int v;
        int wt;
        Pair(int v,int wt){
            this.v= v;
            this.wt = wt;
        }
    }
    public void topological(int node, ArrayList<ArrayList<ShortesPathinDAG.Pair>> adj, boolean[] visited, Stack<Integer> st){
        visited[node] = true;

        for(ShortesPathinDAG.Pair x : adj.get(node)){
            if(visited[x.v]==false){
                topological(x.v,adj,visited,st);
            }
        }
        st.push(node);
    }
    public void LongestPath(ArrayList<ArrayList<ShortesPathinDAG.Pair>> adj, int n, int src){
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                topological(i,adj,visited,st);
            }
        }
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        while(st.size()>0){
            int rem = st.pop();
            if(dist[rem]!=Integer.MAX_VALUE) {
                for (ShortesPathinDAG.Pair x : adj.get(rem)) {
                    if(dist[rem]+x.wt > dist[x.v]){
                        dist[x.v] = dist[rem]+x.wt;
                    }
                }
            }
        }
    }
}
