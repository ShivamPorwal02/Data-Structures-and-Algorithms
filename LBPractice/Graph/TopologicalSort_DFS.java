package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort_DFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                topological(i,adj,visited,st);
            }
        }
        int[] ans = new int[V];
        int idx = 0;
        while(st.size()>0){
            ans[idx] = st.pop();
            idx++;
        }
        return ans;
    }
    public static void topological(int i,ArrayList<ArrayList<Integer>> adj,int[] visited,Stack<Integer> st){
        visited[i] = 1;

        for(int x : adj.get(i)){
            if(visited[x]==0){
                topological(x,adj,visited,st);
            }
        }
        st.push(i);
    }
}
