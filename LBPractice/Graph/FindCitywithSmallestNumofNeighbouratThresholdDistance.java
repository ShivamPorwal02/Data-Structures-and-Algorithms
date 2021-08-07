package LoveBabbar.Graph;

public class FindCitywithSmallestNumofNeighbouratThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];

        for(int i=0;i<edges.length;i++){
            mat[edges[i][0]][edges[i][1]] = edges[i][2];
            mat[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && mat[i][j]==0) mat[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][k]==Integer.MAX_VALUE || mat[k][j]==Integer.MAX_VALUE) continue;
                    else if(mat[i][k]+mat[k][j] < mat[i][j]){
                        mat[i][j] = mat[i][k]+mat[k][j];
                    }
                }
            }
        }
        int cnt = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++){
            int num = 0;
            for(int j=0;j<n;j++){
                if(i!=j && mat[i][j]<=distanceThreshold) num++;
            }
            // System.out.println(num);
            if(num<=cnt){
                ans = i;
                cnt = num;
            }
        }
        return ans;
    }
}
