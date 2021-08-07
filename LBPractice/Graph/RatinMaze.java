package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class RatinMaze {
    public static ArrayList<String> findPath(int[][] grid, int n) {
        // Your code here
        int[][] visited = new int[n][n];
        ArrayList<String> lst = new ArrayList<>();
        maze(0,0,grid,lst,n,visited,"");
        Collections.sort(lst);
        return lst;
    }
    public static void maze(int i,int j,int[][] grid,ArrayList<String> lst,int n,int[][] visited,String psf){
        if(i<0 || j<0 || i>=n || j>=n || visited[i][j]==1 || grid[i][j]==0) return;
        if(i==n-1 && j==n-1){
            lst.add(psf);
            return;
        }
        visited[i][j] = 1;
        maze(i+1,j,grid,lst,n,visited,psf+"D");
        maze(i,j+1,grid,lst,n,visited,psf+"R");
        maze(i-1,j,grid,lst,n,visited,psf+"U");
        maze(i,j-1,grid,lst,n,visited,psf+"L");
        visited[i][j] = 0;
    }
}
