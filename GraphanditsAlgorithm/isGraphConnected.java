package GraphanditsAlgorithm;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.InputStreamReader;
public class isGraphConnected {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void connected(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> a){
        visited[src] = true;
        a.add(src);
        for(Edge edge:graph[src]){
            if(visited[edge.nbr]==false){
                connected(graph,edge.nbr,visited,a);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[vtces];
        for(int i=0;i<vtces;i++){
            if(visited[i]==false){
                ArrayList<Integer> comp = new ArrayList<>();
                connected(graph,i,visited,comp);
                comps.add(comp);
            }
        }
        System.out.println(comps.size()==1);
        // write your code here
    }

}
