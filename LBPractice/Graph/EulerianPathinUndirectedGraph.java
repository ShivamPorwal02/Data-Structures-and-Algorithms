package LoveBabbar.Graph;

import java.util.ArrayList;

public class EulerianPathinUndirectedGraph {
    static int eulerPath(int n, int graph[][]) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    adj.get(i + 1).add(j + 1);
                    // adj.get(j).add(i);
                }
            }
        }
        // for(int i=0;i<adj.size();i++){
        //     System.out.println(adj.get(i)+" "+i);
        // }
        int odd = 0;
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() % 2 == 1) odd += 1;
        }
        if (odd > 2 || odd == 0) return 0;
        return 1;
    }

}
