package LoveBabbar.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class OliverAndTheGame {
    static int timer;
    public static void main(String args[] ) throws Exception {
        timer = 1;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] inTime = new int[n+1];
        int[] outTime = new int[n+1];
        int[] visited = new int[n+1];
        Arrays.fill(visited,-1);

        dfs(1,visited,adj,inTime,outTime);

        int q = Integer.parseInt(br.readLine());

        for(int i=0;i<q;i++){

            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[2]);
            int direction = Integer.parseInt(temp[0]);

            if(inSubtree(x,y,inTime,outTime)==false && inSubtree(y,x,inTime,outTime)==false){
                System.out.println("NO");
                continue;
            }
            if(direction==0){
                if(inSubtree(y,x,inTime,outTime)==false) System.out.println("NO");
                else System.out.println("YES");
            }else{
                if(inSubtree(x,y,inTime,outTime)==false) System.out.println("NO");
                else System.out.println("YES");
            }
        }
    }
    // whether x is in subtree of y
    public static boolean inSubtree(int x,int y,int[] inTime,int[] outTime){
        if(inTime[x]>inTime[y] && outTime[x]<outTime[y]) return true;
        return false;
    }
    public static void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, int[] inTime, int[] outTime){
        visited[node] = 1;
        inTime[node] = timer++;

        for(int x : adj.get(node)){
            if(visited[x]==-1){
                dfs(x,visited,adj,inTime,outTime);
            }
        }
        outTime[node] = timer++;
    }
}
