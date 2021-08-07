package LoveBabbar.Graph;

import java.util.ArrayList;

public class PathMoreThanKLengthFromaSource {
    class Pair{
        int v;
        int weight;
        Pair(int v,int weight){
            this.v = v;
            this.weight = weight;
        }
    }
    boolean pathMoreThanK(int v,int e,int k,int[] arr){
        // Code Here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        for(int i=0;i<3*e;i=i+3){
            adj.get(arr[i]).add(new Pair(arr[i+1],arr[i+2]));
            adj.get(arr[i+1]).add(new Pair(arr[i],arr[i+2]));
        }
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            if(dfs1(0,adj,visited,k)) return true;
        }
        return false;
    }
    boolean dfs1(int node, ArrayList<ArrayList<Pair>> adj, boolean visited[], int k){
        visited[node] = true;
        for(Pair x : adj.get(node)){
            if(visited[x.v]== false){
                if(x.weight>=k) return true;
                visited[x.v] = true;
                if(dfs1(x.v,adj,visited,k-x.weight)) return true;
            }
        }
        visited[node] = false;
        return false;
    }
}
