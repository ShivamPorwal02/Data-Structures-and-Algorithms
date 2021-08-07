package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph_BFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(checkBipartite(i,color,adj)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkBipartite(int i,int[] color,ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;
        while(q.size()>0){
            int rem = q.remove();
            for(int x : adj.get(rem)){
                if(color[x]==-1){
                    color[x] = 1-color[rem];
                    q.add(x);
                }else if(color[x]==color[rem]) return false;
            }
        }
        return true;
    }
}
