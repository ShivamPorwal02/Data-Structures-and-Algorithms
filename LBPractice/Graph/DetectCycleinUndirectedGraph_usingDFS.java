package LoveBabbar.Graph;

import java.util.ArrayList;

public class DetectCycleinUndirectedGraph_usingDFS {
    public boolean hasCycle(int i, int parent, boolean[] isVisited, ArrayList<ArrayList<Integer>> adj){
        isVisited[i] = true;
        for(int x : adj.get(i)){
            if(isVisited[i]==false){
                if(hasCycle(x,i,isVisited,adj)) return true; // imp step vrna ans glt aaega
            }else if(i!=parent) return true;
        }
        return false;
    }
    public boolean isCycle(int v,ArrayList<ArrayList<Integer>> adj){
        boolean[] isVisited = new boolean[v];

        for (int i=0;i<v;i++) {
            if(isVisited[i]==false){
                if(hasCycle(i,-1,isVisited,adj)) return true;
            }
        }
        return false;
    }
}
