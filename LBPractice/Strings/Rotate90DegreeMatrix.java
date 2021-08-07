package LoveBabbar.Strings;

public class Rotate90DegreeMatrix {
    public void rotate(int[][] matrix) {
        // TRANSPOSE
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse the columns

        for(int i=0;i<matrix.length;i++){
            int l=0;
            int r = matrix.length-1;
            while(l<r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
