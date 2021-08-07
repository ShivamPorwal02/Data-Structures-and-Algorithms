package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.List;

public class BridgesinNetwork_CriticalConnectonsinaNetwork {
    int timer;
    List<List<Integer>> lst;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)  adj.add(new ArrayList<>());

        for(List<Integer> list: connections) {
            adj.get(list.get(0)).add(list.get(1));
            adj.get(list.get(1)).add(list.get(0));
        }

        int[] visited = new int[n];
        int[] in = new int[n];
        int[] low = new int[n];

        lst = new ArrayList<>();
        timer = 0;

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,-1,visited,in,low,adj);
            }
        }
        return lst;
    }
    public void dfs(int node,int parent,int[] visited,int[] in,int[] low,
                    ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        in[node] = low[node] = timer++;

        for(int it : adj.get(node)){
            if(it==parent) continue;

            if(visited[it]==0){
                dfs(it,node,visited,in,low,adj);
                low[node] = Math.min(low[node],low[it]);

                if(low[it]>in[node]){
                    List<Integer> lst1 = new ArrayList<>();
                    lst1.add(it);
                    lst1.add(node);
                    lst.add(lst1);
                }
            }else{
                low[node] = Math.min(low[node],in[it]);
            }
        }
    }
}
