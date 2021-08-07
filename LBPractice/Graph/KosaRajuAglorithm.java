package LoveBabbar.Graph;

import java.util.*;

public class KosaRajuAglorithm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

    }
    public ArrayList<ArrayList<Integer>> tarjans(int n, ArrayList<ArrayList<Integer>> adj)
    {
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
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        while(st.size()>0){
            int node = st.pop();
            if(visited[node]==0){
                ArrayList<Integer> lst1 = new ArrayList<>();
                revDfs(node,visited,transpose,lst1);
                Collections.sort(lst1);
                lst.add(lst1);
            }
        }
        // ye sorting gfg m submission k vjh se kia hai
        Collections.sort(lst,((a,b)->a.get(0)-b.get(0)));
        return lst;
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
    public void revDfs(int node,int[] visited,ArrayList<ArrayList<Integer>> transpose,ArrayList<Integer> lst){
        visited[node]  =1;
        lst.add(node);
        for(int it : transpose.get(node)){
            if(visited[it]==0){
                revDfs(it,visited,transpose,lst);
            }
        }
    }
}
