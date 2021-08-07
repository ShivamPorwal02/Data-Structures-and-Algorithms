package GraphanditsAlgorithm;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.InputStreamReader;
public class HamiltonianPathandCycle {
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
    public static boolean isNeighbour(ArrayList<Edge>[] graph,int src,int nbr){
        for(Edge edge : graph[src]){
            if(nbr==edge.nbr){
                return true;
            }
        }
        return false;
    }
    public static void connected(ArrayList<Edge>[] graph,int src,boolean[] visited,String psf,int osrc){

        if(psf.length()==graph.length){
            //   System.out.println(psf.charAt(psf.length()-1));
            if(isNeighbour(graph,osrc,Integer.parseInt(psf.charAt(psf.length()-1)+""))){
                System.out.println(psf+"*");
            }else{
                System.out.println(psf+".");
            }
            return;
        }
        visited[src] = true;
        //   a.add(src);
        for(Edge edge : graph[src]){
            if(visited[edge.nbr]==false){
                connected(graph,edge.nbr,visited,psf+edge.nbr,osrc);
            }
        }
        visited[src] = false;
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

        boolean[] visited = new boolean[vtces];
        int src = Integer.parseInt(br.readLine());
        connected(graph,src,visited,src+"",src);
    }

}
