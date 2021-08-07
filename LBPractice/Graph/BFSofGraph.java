package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSofGraph {
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> lst = new ArrayList<>();
        boolean[] isVisited = new boolean[v];
        for(int i=0;i<v;i++){
            if(isVisited[i]==false){

                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                isVisited[i] = true;

                while(q.size()>0){
                    Integer rem = q.poll();
                    lst.add(rem);
                    for(Integer x : adj.get(rem)){
                        if(isVisited[x]==false){
                            isVisited[x] = true;
                            q.add(x);
                        }
                    }
                }
            }
        }
        return lst;
    }
}
