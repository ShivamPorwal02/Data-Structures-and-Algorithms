package LoveBabbar.Heap;

public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length!=r*c)return mat;

        int[][] ans = new int[r][c];
        int cnt = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                ans[cnt/c][cnt%c] = mat[i][j];
                cnt++;
            }
        }
        return ans;
    }
}
