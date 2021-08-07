package LoveBabbar.Graph;

public class NumberofTrianglesinDirectedandUndirectedGraph {
    int countTriangle(int graph[][],
                      boolean isDirected,int V)
    {
        // Initialize result
        int count_Triangle = 0;

        // Consider every possible
        // triplet of edges in graph
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                for (int k=0; k<V; k++)
                {
                    // Check the triplet if it
                    // satisfies the condition
                    if (graph[i][j] == 1 &&
                            graph[j][k] == 1 &&
                            graph[k][i] == 1)
                        count_Triangle++;
                }
            }
        }

        // If graph is directed , division
        // is done by 3 else division
        // by 6 is done
        if(isDirected == true)
        {
            count_Triangle /= 3;
        }
        else
        {
            count_Triangle /= 6;
        }
        return count_Triangle;
    }
}
