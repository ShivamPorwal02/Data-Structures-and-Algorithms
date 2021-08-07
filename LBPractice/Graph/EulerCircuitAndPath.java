package LoveBabbar.Graph;

import java.util.ArrayList;

public class EulerCircuitAndPath {
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int odd = 0;
        for(int i=0;i<V;i++){
            if(adj.get(i).size()%2==1) odd+=1;
        }
        if(odd==2) return 1;
        if(odd>2) return 0;
        return 2;
    }
}
