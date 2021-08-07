package GraphanditsAlgorithm;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;
public class SpreadInfection {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static class Pair{
        int v;
        String psf;
        int level;
        Pair(int v,String psf,int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }
    static int flag = 0;
    static int cnt = 0;
    public static void connectedBFS(ArrayList<Edge>[] graph,int src,int[] visited,int k){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,src+"",0));

        while(q.size()>0){
            Pair rem = q.remove();
            if(rem.level==k){
                break;
            }else {
                if(visited[rem.v]==-1){
                    cnt++;
                }
                visited[rem.v] = rem.level;
            }

            for(Edge e : graph[rem.v]){
                if(visited[e.nbr]==-1){
                    q.add(new Pair(e.nbr,rem.psf+e.nbr,rem.level+1));
                }
            }
        }
        return ;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int[] visited = new int[vtces];
        Arrays.fill(visited,-1);
        connectedBFS(graph,src,visited,t);
        System.out.println(cnt);

    }

}
