package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST_PrimsAlgorithm {

    // ye NlogN m

    static class Pair{
        int v;
        int dist;
        Pair(int v,int dist){
            this.v = v;
            this.dist = dist;
        }
    }

    // ye idk y gfg m ya to test cases ka pnga hai ya kch ye submit ni hora

    static int spanningTree_(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        // Add your code here
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] mstSet = new boolean[n];

        // mstSet islia kia hai taaki cycle ni bne

        for(int i=0;i<n;i++){
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mstSet[i] = false;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Integer.compare(a.dist,b.dist));


        // hmne fir pehle element ko choose krra
        key[0] = 0;
        pq.add(new Pair(0,key[0]));

        // ye loop n-1 baar islia chla hai kyuki hme n-1 edges hi chahia hoti hai mst m

        while(pq.size()>0){
            int selectedNode = pq.remove().v;
            mstSet[selectedNode] = true;

            for(ArrayList<Integer> x : adj.get(selectedNode)){
                if(mstSet[x.get(0)]==false  && x.get(1) < key[x.get(0)]){
                    key[x.get(0)] = x.get(1);
                    parent[x.get(0)] = selectedNode;
                    pq.add(new Pair(x.get(0),key[x.get(0)]));
                }
            }
        }
        int total = 0;
        for(int i=1;i<n;i++) total+=key[i];
        return total;
    }

    // ye N2 hai m hai

    static int spanningTree(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        // Add your code here
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] mstSet = new boolean[n];

        // mstSet islia kia hai taaki cycle ni bne

        for(int i=0;i<n;i++){
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mstSet[i] = false;
        }
        // hmne fir pehle element ko choose krra
        key[0] = 0;

        // ye loop n-1 baar islia chla hai kyuki hme n-1 edges hi chahia hoti hai mst m

        for(int i=0;i<n-1;i++){
            int min = Integer.MAX_VALUE;
            int selectedNode = 0; // ese hi dia hai abhi
            for(int v=0;v<n;v++){
                if(mstSet[v]==false && key[v]<min){
                    min = key[v];
                    selectedNode = v;
                }
            }
            mstSet[selectedNode] = true;

            for(ArrayList<Integer> x : adj.get(selectedNode)){
                if(mstSet[x.get(0)]==false  && x.get(1) < key[x.get(0)]){
                    key[x.get(0)] = x.get(1);
                    parent[x.get(0)] = selectedNode;
                }
            }
        }
        int total = 0;
        for(int i=1;i<n;i++) total+=key[i];
        return total;
    }
}
