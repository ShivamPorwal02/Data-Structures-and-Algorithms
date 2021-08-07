package LoveBabbar.Graph;

import java.util.ArrayList;

public class DFSofGraph {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> lst = new ArrayList<>();
        boolean[] isVisited = new boolean[V];
        for(int i=0;i<V;i++) {
            if(isVisited[i]==false) {
                dfs(i, isVisited, adj, lst);
            }
        }
        return lst;
    }
    public void dfs(int i,boolean[] isVisited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> lst){
        lst.add(i);
        isVisited[i] = true;

        for(int x : adj.get(i)){
            if(isVisited[x]==false){
                dfs(x,isVisited,adj,lst);
            }
        }
    }
}
