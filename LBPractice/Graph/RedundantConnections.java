package LoveBabbar.Graph;

public class RedundantConnections {
    static int parent[];
    static int rank[];
    public void makeSet(int n){
        for(int i=1;i<=n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int findParent(int node){
        if(node==parent[node]) return node;
        return parent[node] = findParent(parent[node]); // issi step m path compression hora hai
    }
    public void union(int u,int v){
        u = findParent(u);
        v = findParent(v);

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
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];

        makeSet(n);

        int[] ans = new int[2];

        for(int i=0;i<edges.length;i++){
            int u = findParent(edges[i][0]);
            int v = findParent(edges[i][1]);

            if(u==v){
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
            }else{
                union(u,v);
            }
        }
        return ans;
    }
}
