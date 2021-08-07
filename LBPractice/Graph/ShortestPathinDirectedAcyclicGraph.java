package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Pair{
    int neigh;
    int weight;
    Pair(int neigh,int weight){
        this.neigh = neigh;
        this.weight = weight;
    }
}
public class ShortestPathinDirectedAcyclicGraph {

    public void topological(int i,ArrayList<ArrayList<Pair>>adj,Stack<Integer> st,int[] visited){
        visited[i] = 1;

        for(Pair x : adj.get(i)){
            if(visited[x.neigh]==0){
                topological(x.neigh,adj,st,visited);
            }
        }
        st.push(i);
    }
    public void shortestPath(int src,ArrayList<ArrayList<Pair>>adj,int n){
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[n];
        for (int i=0;i<n ;i++ ) {
            if(visited[i]==0){
                topological(i,adj,st,visited);
            }
        }
        int[] dist = new int[n];
        for (int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        while(st.size()>0){
            int rem = st.pop();
            if(dist[rem]!=Integer.MAX_VALUE){
                for (Pair x : adj.get(rem)){
                    if(dist[rem]+x.weight<dist[x.neigh]){
                        dist[x.neigh] = dist[rem]+x.weight;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Pair>> lst = new ArrayList<>();

    }

}
