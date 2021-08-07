package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Collections;

class KruskalAlgorithm {
    class Pair implements Comparable<Pair>{
        int u;
        int v;
        int weight;
        Pair(int u,int v,int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        @Override
        public int compareTo(Pair p2){
            return this.weight-p2.weight;
        }
    }
    public void kruskal(ArrayList<Pair> adj,int n){
        Collections.sort(adj);
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0;i<n;i++){
            rank[i] = 0;
            parent[i] = i;
        }

        int costMst = 0;
        ArrayList<Pair> mst = new ArrayList<>();
        for (Pair it : adj ) {
            if(findParent(it.u,parent)!=findParent(it.v,parent)){
                costMst+=it.weight;
                mst.add(it);
                union(it.u,it.v,parent,rank);
            }
        }
        for(Pair p : mst){
            System.out.println(p.u+"--"+p.v);
        }
    }
    public int findParent(int node,int[] parent){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node],parent);
    }
    public void union(int u,int v,int[] parent,int[] rank){
        u = findParent(u,parent);
        v = findParent(v,parent);

        if(rank[u]>rank[v]){
            parent[v] = u;
        }else if(rank[v]>rank[u]){
            parent[u] = v;
        }else{
            // koi bhi kisika
            parent[u] = v;
            rank[v]++;
        }
    }
}
