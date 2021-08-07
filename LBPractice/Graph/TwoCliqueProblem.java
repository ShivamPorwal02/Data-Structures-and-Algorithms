package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoCliqueProblem {
    public boolean canTwoClique(ArrayList<ArrayList<Integer>> adj,int n){
        ArrayList<ArrayList<Integer>> complement = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        boolean[] visited = new boolean[n];
        for (int i=0;i<n ;i++ ) {
            for(int x : adj.get(i)){
                visited[x] = true;
            }
            for (int j=0;j<n ;j++ ) {
                if(visited[j]==false){
                    complement.get(i).add(j);
                    complement.get(j).add(i);
                }
            }
            visited = new boolean[n];
        }
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(isBipartite(i,complement,color)==false) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int node,ArrayList<ArrayList<Integer>> adj,int[] color){
        if(color[node]==-1) color[node] = 1;

        for (int x : adj.get(node)) {
            if(color[x]==-1){
                color[x] = 1 - color[node];
                if(isBipartite(x,adj,color)==false) return false;
            }else if(color[node]==color[x]) return false;
        }
        return true;
    }
}
