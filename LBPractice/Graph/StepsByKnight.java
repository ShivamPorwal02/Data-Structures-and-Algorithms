package LoveBabbar.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        // Code here
        int x1 = KnightPos[0]-1;
        int y1 = KnightPos[1]-1;
        int x2 = TargetPos[0]-1;
        int y2 = TargetPos[1]-1;

        int[][] grid = new int[n][n];
        // We have to use BFS here because BFS works in parallel for all the approachable path and so whenever we reach the destination with any path then that first path will always be minimum. And this is why we have to use BFS as it works in parallel.
// And we can not use DFS here because with DFS we will keep on moving in depth till we either reach the destination or we visit all the cells and no more cells to visit. And so then we will backtrack and then we will try another path and with that another path suppose we are able to reach then we can not be sure that this is path is minimum path only. Because DFS does not work in parallel. And so if we are using DFS then we have to use traverse all the possible paths and then only we can select minimum out of all of them.
// But with BFS first path with which we reach destination is always be the minimum path

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x1,y1));
        while(q.size()>0){
            Pair rem = q.remove();

            int i = rem.x;
            int j = rem.y;

            if(i+2<n && j+1<n && i+2>=0 && j+1>=0 && grid[i+2][j+1]==0){
                grid[i+2][j+1] = grid[i][j]+1;
                q.add(new Pair(i+2,j+1));
            }

            if(i+2<n && j-1<n && i+2>=0 && j-1>=0 && grid[i+2][j-1]==0){
                grid[i+2][j-1] = grid[i][j]+1;
                q.add(new Pair(i+2,j-1));
            }

            if(i+1<n && j+2<n && i+1>=0 && j+2>=0 && grid[i+1][j+2]==0){
                grid[i+1][j+2] = grid[i][j]+1;
                q.add(new Pair(i+1,j+2));
            }
            if(i+1<n && j-2<n && i+1>=0 && j-2>=0 && grid[i+1][j-2]==0){
                grid[i+1][j-2] = grid[i][j]+1;
                q.add(new Pair(i+1,j-2));
            }

            if(i-1<n && j+2<n && i-1>=0 && j+2>=0 && grid[i-1][j+2]==0){
                grid[i-1][j+2] = grid[i][j]+1;
                q.add(new Pair(i-1,j+2));
            }

            if(i-1<n && j-2<n && i-1>=0 && j-2>=0 && grid[i-1][j-2]==0){
                grid[i-1][j-2] = grid[i][j]+1;
                q.add(new Pair(i-1,j-2));
            }

            if(i-2<n && j+1<n && i-2>=0 && j+1>=0 && grid[i-2][j+1]==0){
                grid[i-2][j+1] = grid[i][j]+1;
                q.add(new Pair(i-2,j+1));
            }

            if(i-2<n && j-1<n && i-2>=0 && j-1>=0 && grid[i-2][j-1]==0){
                grid[i-2][j-1] = grid[i][j]+1;
                q.add(new Pair(i-2,j-1));
            }

        }
        return grid[x2][y2];
    }
}
