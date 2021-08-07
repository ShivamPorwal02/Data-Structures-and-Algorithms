package LoveBabbar.Graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] visited = new int[image.length][image[0].length];
        int color = image[sr][sc];
        dfs(sr,sc,image,visited,newColor,image.length,image[0].length,color);
        return image;
    }
    public void dfs(int i,int j,int[][] image,int[][] visited,int newColor,int m,int n,int color){
        if(i<0 || j<0 || i>=m || j>=n || image[i][j] != color|| visited[i][j] == 1) return;

        image[i][j] = newColor;
        visited[i][j] = 1;
        dfs(i+1,j,image,visited,newColor,m,n,color);
        dfs(i,j+1,image,visited,newColor,m,n,color);
        dfs(i-1,j,image,visited,newColor,m,n,color);
        dfs(i,j-1,image,visited,newColor,m,n,color);
        visited[i][j] = 0;

    }
}
