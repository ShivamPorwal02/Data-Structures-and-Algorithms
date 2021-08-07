package LoveBabbar.Graph;

public class FloydWarsall {
    public void shortest_distance(int[][] matrix)
    {
        // Code here
        int n = matrix.length;

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k]==Integer.MAX_VALUE || matrix[k][j]==Integer.MAX_VALUE) continue;
                    else if(matrix[i][k]+matrix[k][j] < matrix[i][j]){
                        matrix[i][j] = matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }
    }
}
