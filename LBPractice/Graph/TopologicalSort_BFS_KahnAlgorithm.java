package LoveBabbar.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TopologicalSort_BFS_KahnAlgorithm {
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] topo = new int[n];
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

        int idx = 0;
        while(q.size()>0){
            int temp = q.remove();
            topo[idx++] = temp;

            for(int x : adj.get(temp)){
                indegree[x]--;
                if(indegree[x]==0) q.add(x);
            }
        }
        return topo;
    }
}
