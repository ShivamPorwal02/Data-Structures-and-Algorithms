package LoveBabbar.Graph;

import java.util.ArrayList;

public class EulerCircuitinanUndirectedGraph {
    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        return Euler(adj,V)==1? true : false;

    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[node] = true;
        for(int x : adj.get(node)){
            if(visited[x]==false){
                dfs(x,adj,visited);
            }
        }
    }
    public boolean connected(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] visited = new boolean[V];
        int node = -1;
        for(int i=0;i<adj.size();i++){
            if(adj.get(i).size()>0){
                node = i;
                break;
            }
        }
        if(node==-1) return true;
        dfs(node,adj,visited);

        for(int i=0;i<V;i++){
            if(visited[i]==false && adj.get(i).size()>0) return false;
        }
        return true;
    }
    public int Euler(ArrayList<ArrayList<Integer>> adj,int V){
        if(connected(adj,V)==false) return 0;

        int odd = 0;
        for(int i=0;i<V;i++){
            if(adj.get(i).size()%2==1) odd+=1;
        }
        if(odd>2) return 0;
        return odd==0 ? 1 : 0;
    }
}
