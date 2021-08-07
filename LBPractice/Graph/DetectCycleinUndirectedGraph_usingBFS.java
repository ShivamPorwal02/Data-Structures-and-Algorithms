package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleinUndirectedGraph_usingBFS {
    class Pair{
        int curr;
        int prev;
        Pair(int curr,int prev){
            this.curr = curr;
            this.prev = prev;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here

        boolean[] isVisited = new boolean[V];

        for(int i=0;i<V;i++){
            if(isVisited[i]==false){
                if(hasCycle(i,adj,isVisited)) return true;
            }
        }
        return false;
    }
    public boolean hasCycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,-1));
        isVisited[i] = true;

        while(q.size()>0){
            Pair rem = q.remove();
            int curr = rem.curr;
            int prev = rem.prev;

            for(int x : adj.get(curr)){
                if(isVisited[x]==false){
                    isVisited[x] = true;
                    q.add(new Pair(x,curr));
                }else if(x!=prev) return true;
            }
        }
        return false;
    }
}
