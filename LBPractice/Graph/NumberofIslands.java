package LoveBabbar.Graph;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int cnt = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && visited[i][j] == 0){
                    dfs(i,j,grid,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int i,int j,char[][] grid,int[][] visited){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==1 || grid[i][j]=='0'){
            return;
        }

        visited[i][j] = 1;
        dfs(i+1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i,j-1,grid,visited);
        dfs(i-1,j,grid,visited);
    }
}
