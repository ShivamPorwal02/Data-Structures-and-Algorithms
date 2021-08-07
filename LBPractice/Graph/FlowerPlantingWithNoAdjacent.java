package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i =0 ;i<paths.length;i++){
            adj.get(paths[i][0]).add(paths[i][1]);
            adj.get(paths[i][1]).add(paths[i][0]);
        }

        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        int m = 4;
        // ArrayList<Integer> lst = new ArrayList<>();
        solve(1,adj,color,n,m);
        int[] ans = new int[n];
        for(int i=1;i<=n;i++) ans[i-1] = color[i];
        return ans;

    }
    public static boolean solve(int node, ArrayList<ArrayList<Integer>> adj, int[] color, int n, int m){
        if(node==n+1){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(isSafe(node,adj,color,n,i)){
                color[node] = i;
                if(solve(node+1,adj,color,n,m)==true){
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int node,ArrayList<ArrayList<Integer>> adj,int[] color,int n,int col){
        for(int it : adj.get(node)){
            if(color[it]==col) return false;
        }
        return true;
    }
}
