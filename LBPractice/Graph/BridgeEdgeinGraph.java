package LoveBabbar.Graph;

import java.util.ArrayList;

public class BridgeEdgeinGraph {
    static int isBridge(int n, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        int vis[] = new int[n];
        int tin[] = new int[n];
        int low[] = new int[n];

        int timer = 0;
        for(int i = 0;i<n;i++) {
            if(vis[i] == 0) {
                if(dfs(i, -1, vis, tin, low, adj, timer,c,d)==1) return 1;;
            }
        }
        return 0;
    }
    private static int dfs(int node, int parent, int vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int timer, int c, int d) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;

        for(Integer it: adj.get(node)) {
            if(it == parent) continue;

            if(vis[it] == 0) {
                if(dfs(it, node, vis, tin, low, adj, timer,c,d)==1) return 1;
                low[node] = Math.min(low[node], low[it]);

                if(low[it] > tin[node]) {
                    if(it==c && node==d || node == c && it==d) return 1;
                }
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        return 0;
    }
}
