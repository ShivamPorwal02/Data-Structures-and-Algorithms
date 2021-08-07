package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraph_DFS {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++){
            lst.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                lst.get(i).add(graph[i][j]);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(checkBipartiteDFS(i,color,lst)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkBipartiteDFS(int i,int[] color,ArrayList<ArrayList<Integer>> adj){
        if(color[i]==-1) color[i] = 1;


        for(int x : adj.get(i)){
            if(color[x]==-1){
                color[x] = 1 - color[i];
                if(checkBipartiteDFS(x,color,adj)==false) return false;
            }else if(color[x]==color[i]) return false;
        }
        return true;
    }
}
