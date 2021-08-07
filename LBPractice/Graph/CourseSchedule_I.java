package LoveBabbar.Graph;

import java.util.ArrayList;

public class CourseSchedule_I {
    public boolean canFinish(int n, int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<2;j++){
                adj.get(graph[i][0]).add(graph[i][1]);
            }
        }

        int[] visited = new int[n];
        int[] dfsVisited = new int[n];

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                if(hasCycle(i,adj,visited,dfsVisited)) return false;
            }
        }
        return true;
    }
    public boolean hasCycle(int i, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] dfsVisited){
        visited[i] = 1;
        dfsVisited[i] = 1;

        for(int x : adj.get(i)){
            if(visited[x]==0){
                if(hasCycle(x,adj,visited,dfsVisited)) return true;
            }else if(visited[x]==1 && dfsVisited[x]==1) return true;
        }
        dfsVisited[i] = 0; // wapas aate hue 0 krna hai
        return false;
    }
}
