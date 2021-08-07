package LoveBabbar.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceinMaze {
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int cnt = Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] ent) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] visited = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ent[0],ent[1]));

        while(q.size()>0){
            int size = q.size();
            while(size>0){
                Pair rem = q.remove();
                int i = rem.x;
                int j = rem.y;
                if(!(ent[0]+"$"+ent[1]).equals(rem.x+"$"+rem.y) && (i==0 || i==m-1 || j==0 || j==n-1)) return visited[i][j];
                if(i+1<m && j<n && i+1>=0 && j>=0 && visited[i+1][j]==0 && maze[i+1][j]=='.'){
                    visited[i+1][j] = visited[i][j]+1;
                    q.add(new Pair(i+1,j));
                }
                if(i<m && j+1<n && i>=0 && j+1>=0 && visited[i][j+1]==0 && maze[i][j+1]=='.'){
                    visited[i][j+1] = visited[i][j]+1;
                    q.add(new Pair(i,j+1));
                }
                if(i<m && j-1<n && i>=0 && j-1>=0 && visited[i][j-1]==0 && maze[i][j-1]=='.'){
                    visited[i][j-1] = visited[i][j]+1;
                    q.add(new Pair(i,j-1));
                }
                if(i-1<m && j<n && i-1>=0 && j>=0 && visited[i-1][j]==0 && maze[i-1][j]=='.'){
                    visited[i-1][j] = visited[i][j]+1;
                    q.add(new Pair(i-1,j));
                }
                size--;
            }

        }
        for(int[] arr : visited) System.out.println(Arrays.toString(arr));
        return cnt==Integer.MAX_VALUE ? -1 : cnt;
    }
}
