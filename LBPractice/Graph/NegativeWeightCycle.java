package LoveBabbar.Graph;

public class NegativeWeightCycle {
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i] = 100000000;

        dist[0] = 0;

        for(int i=0;i<n-1;i++){
            for(int j = 0;j<edges.length;j++){
                if(dist[edges[j][0]]+edges[j][2] < dist[edges[j][1]]){
                    dist[edges[j][1]] = dist[edges[j][0]]+edges[j][2];
                }
            }
        }

        for(int j = 0 ;j<edges.length;j++){
            if(dist[edges[j][0]]+edges[j][2] < dist[edges[j][1]]){
                return 1;
            }
        }
        return 0;
    }
}
