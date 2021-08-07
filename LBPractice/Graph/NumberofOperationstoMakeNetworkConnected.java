package LoveBabbar.Graph;

import java.util.ArrayList;

public class NumberofOperationstoMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;

        int[] visited = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }

        int cnt = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,adj,visited);
                cnt++;
            }
        }
        return cnt-1;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited){
        visited[node] = 1;

        for(int x : adj.get(node)){
            if(visited[x]==0){
                dfs(x,adj,visited);
            }
        }
    }
}
