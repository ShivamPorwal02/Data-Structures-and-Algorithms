package LoveBabbar.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JourneryToMoon {
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(List<Integer> x : astronaut){
            adj.get(x.get(0)).add(x.get(1));
            adj.get(x.get(1)).add(x.get(0));
        }
        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        long samePair = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
                cnt=0;
                int cnt = dfs(i,adj,visited);
                // System.out.println(cnt);
                samePair+=(cnt*(cnt-1)/2);
            }
        }
        long result = n;
        result*=(n-1);
        result/=2;

        return result-samePair;
    }
    static int cnt;
    public static int dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited){
        visited[node] = 1;
        cnt++;
        for(int x : adj.get(node)){
            if(visited[x]==-1){
                dfs(x,adj,visited);
            }
        }
        return cnt;
    }
}


