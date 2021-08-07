package LoveBabbar.Graph;

import java.util.ArrayList;

public class DetectCycleinDirectedGraph_DFS {
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        int[] visited = new int[N];
        int[] dfsVisited = new int[N];

        for(int i=0;i<N;i++){
            if(visited[i]==0){
                if(hasCycle(i,adj,visited,dfsVisited)) return true;
            }
        }
        return false;
    }
    public boolean hasCycle(int i, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] dfsVisited){
        visited[i] = 1;
        dfsVisited[i] = 1;

        for(int x : adj.get(i)){
            if(visited[x]==0){
                if(hasCycle(x,adj,visited,dfsVisited)) return true;
            }else if(visited[x]==1 && dfsVisited[x]==1) return true;
        }
        dfsVisited[i] = 0; // wapas aate hue 0 krna hai
        return false;
    }
}
