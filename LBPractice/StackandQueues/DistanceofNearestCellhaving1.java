package LoveBabbar.StackandQueues;

import java.util.ArrayDeque;
import java.util.Queue;

public class DistanceofNearestCellhaving1 {
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public int[][] nearest(int[][] mat) {
        Queue<Pair> q = new ArrayDeque<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    q.add(new Pair(i,j));
                    mat[i][j] = 0;
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int cnt = 1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair rem = q.remove();

                for(int[] dir : dirs){
                    int x = rem.i + dir[0];
                    int y = rem.j + dir[1];
                    if(x>=0 && y>=0 && x<mat.length &&
                            y<mat[0].length && mat[x][y] ==Integer.MAX_VALUE)
                    {
                        mat[x][y] = cnt;
                        q.add(new Pair(x,y));
                    }else{
                        continue;
                    }
                }
            }
            cnt++;
        }
        return mat;
    }
}
