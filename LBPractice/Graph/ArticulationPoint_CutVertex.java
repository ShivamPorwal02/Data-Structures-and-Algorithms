package LoveBabbar.Graph;

import java.util.ArrayList;

public class ArticulationPoint_CutVertex {
    public void cutVertex(ArrayList<ArrayList<Integer>> adj,int n){
        int[] visited = new int[n];
        int[] in = new int[n];
        int[] low = new int[n];

        int[] isArticulated = new int[n];

        int timer = 0;
        for (int i=0;i<n;i++ ) {
            if(visited[i]==0){
                dfs(i,-1,visited,in,low,adj,timer,isArticulated);
            }
        }
        for (int i=0;i<n ;i++ ) {
            if(isArticulated[i]==1) System.out.println(i);
        }
    }
    public void dfs(int node,int parent,int[] visited,int[] in,int[] low,ArrayList<ArrayList<Integer>> adj,
                    int timer,int[] isArticulated){
        visited[node] = 1;
        in[node] = low[node] = timer++;
        int child = 0;

        for(int it : adj.get(node)){
            if(it==parent) continue;
            if(visited[it]==0){
                dfs(it,node,visited,in,low,adj,timer,isArticulated);
                low[node] = Math.min(low[node],low[it]);
                if(low[it]>=in[node] && parent!=-1){
                    isArticulated[node] = 1;
                }
                child++;
            }else{
                low[node] = Math.min(low[node],in[it]);
            }
        }
        if(parent==-1 && child>1) isArticulated[node] = 1;
    }
}
