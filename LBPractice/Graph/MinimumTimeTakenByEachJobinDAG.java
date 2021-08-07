package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeTakenByEachJobinDAG {
    public int[] topo_variant(ArrayList<ArrayList<Integer>> adj,int n){
        int[] time = new int[n];
        int[] inDegree = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int x : adj.get(i)){
                inDegree[x]++;
            }
        }
        for (int i=0;i<n ;i++ ) {
            if(inDegree[i]==0){
                q.add(i);
                time[i] = 1;
            }
        }
        while(q.size()>0){
            int temp = q.remove();

            for (int x: adj.get(temp)) {
                inDegree[x]--;
                if(inDegree[x]==0){
                    q.add(x);
                    time[x] = time[temp]+1;
                }
            }
        }
        return time;
    }
}
