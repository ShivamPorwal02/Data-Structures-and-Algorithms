package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StronglyConnectedComponents_number_KosarajuAlgo {
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int[] visited = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,visited,adj,st);
            }
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();

        for(int i=0;i<n;i++){
            transpose.add(new ArrayList<>());
        }
        Arrays.fill(visited,0);

        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                transpose.get(it).add(i);
            }
        }
        int cnt = 0;
        while(st.size()>0){
            int node = st.pop();
            if(visited[node]==0){
                revDfs(node,visited,transpose);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node] =1;

        for(int it : adj.get(node)){
            if(visited[it]==0){
                dfs(it,visited,adj,st);
            }
        }
        st.push(node);
    }
    public void revDfs(int node,int[] visited,ArrayList<ArrayList<Integer>> transpose){
        visited[node]  =1;

        for(int it : transpose.get(node)){
            if(visited[it]==0){
                revDfs(it,visited,transpose);
            }
        }
    }
}
