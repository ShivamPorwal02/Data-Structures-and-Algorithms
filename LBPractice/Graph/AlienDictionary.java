package LoveBabbar.Graph;

import java.util.ArrayList;

public class AlienDictionary {
    public String findOrder(String [] words, int n, int k)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<k;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];

            for(int j=0;j<Math.min(s1.length(),s2.length());j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                }
            }
        }
        String s = "";
        int[] visited = new int[26];
        for(int i=0;i<k;i++){
            if(visited[i]==0){
                topological(i,adj,visited,s);
            }
        }
        return s;
    }
    public void topological(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,String s){
        visited[node] = 1;

        for(int x : adj.get(node)){
            if(visited[x] == 0){
                topological(x,adj,visited,s);
            }
        }
        char c = (char)(node+(int)'a');
        s = c + s+"";
    }
}
