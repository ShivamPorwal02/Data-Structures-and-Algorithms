package LoveBabbar.StackandQueues;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int mint = 0;
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair rem = q.remove();
                for(int[] dir : dirs){
                    int x = rem.i + dir[0];
                    int y = rem.j + dir[1];

                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;

                    q.add(new Pair(x,y));
                    fresh--;
                }
            }
            mint++;
        }
        return fresh==0 ? mint-1 : -1;
    }
}
