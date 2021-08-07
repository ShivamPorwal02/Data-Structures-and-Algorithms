package GraphanditsAlgorithm;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.util.ArrayList;

public class PerfectFriends {
    public static class Edge{
        int src;
        int nbr;
        // int wt;
        Edge(int src,int nbr){
            this.src = src;
            this.nbr = nbr;
            // this.wt = wt;
        }
    }
    public static void connected(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> a){
        visited[src] = true;
        a.add(src);
        for(Edge edge : graph[src]){
            if(visited[edge.nbr]==false){
                connected(graph,edge.nbr,visited,a);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<k;i++){
            String s = br.readLine();
            String[] parts = s.split(" ");

            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                ArrayList<Integer> comp = new ArrayList<>();
                connected(graph,i,visited,comp);
                comps.add(comp);
            }
        }
        //  System.out.println(comps);
        int cnt = 0;
        for(int i=0;i<comps.size();i++){
            for(int j=i+1;j<comps.size();j++){
                cnt+=comps.get(i).size()*comps.get(j).size();
            }
        }
        System.out.println(cnt);
    }

}
