package LoveBabbar.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DetectCycleinDirectedGraph_BFS {
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj)
    {
        // code here

        int[] indegree = new int[n];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            for(int x : adj.get(i)){
                indegree[x]++;
            }
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int cnt = 0;
        while(q.size()>0){
            int temp = q.remove();
            cnt++;

            for(int x : adj.get(temp)){
                indegree[x]--;
                if(indegree[x]==0) q.add(x);
            }
        }
        return cnt==n ? false : true;
    }

}
