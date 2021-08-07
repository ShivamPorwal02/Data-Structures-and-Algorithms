package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i =0 ;i<dislikes.length;i++){
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        int[] color = new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(checkBipartite(i,adj,color)==false) return false;
            }
        }
        return true;
    }
    public boolean checkBipartite(int node,ArrayList<ArrayList<Integer>> adj,int[] color){
        if(color[node]==-1) color[node] = 1;

        for(int x : adj.get(node)){
            if(color[x]==-1){
                color[x] = 1-color[node];
                if(checkBipartite(x,adj,color)==false) return false;
            }else if(color[x]==color[node]) return false;
        }
        return true;
    }
}
