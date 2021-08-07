package LoveBabbar.Graph;

import java.util.ArrayList;

public class graph {
    public static void main(String[] args) {
        int n = 3; // no of node
        int m = 3; // no of edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // assuming ki grpah m 1 se suru honge nodes
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        // Assuming undirected graph

        // edge 1--2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // edge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);


        // edge 1--3
        adj.get(1).add(3);
        adj.get(3).add(1);

        for(int i=0;i<n+1;i++){
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print("Edge "+ i +"--"+adj.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }
}
