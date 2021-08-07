package LoveBabbar.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadder {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        if(n%2!=0 && board[0][n-1]!=-1) return -1;
        if(n%2==0 && board[0][0]!=-1) return -1;
        Queue<Integer> q = new LinkedList<>();
        boolean[]visited = new boolean[n*n+1];
        int move = 1; // kyuki beech m hi return krre hai to ek phle se hi lege chlo

        visited[1] = true;
        q.add(1);

        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int rem = q.remove();
                for(int dice=1;dice<=6;dice++){
                    int next = rem+dice;
                    int[] pos = numToPos(next,n);

                    if(board[pos[0]][pos[1]]>0){
                        next = board[pos[0]][pos[1]];
                    }

                    if(next==n*n) return move;

                    if(visited[next]==false){
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            move++;
        }
        return -1;
    }
    private int[] numToPos(int target,int n) {
        // Visualise it as if converting 2D matrix to 1D.
        int row = (target - 1) / n;
        int col = (target - 1) % n;

//  Since rows starting from the bottom. Therefore,  Rth row will be n-1-R row from the bottom.
        int x = n - 1 - row;

        //  Now, we are looking at rows from bottom.  Notice if the row number is even then it starts from left to right  otherwise from right to left.
        int y = row % 2 == 0 ? col : n - 1 - col;

        return new int[]{x, y};
    }
}
