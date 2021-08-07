package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class OrderofLargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if(mines.length==0) return n/2;
        int[][] grid = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(grid[i],1);
        }
        for(int[] m : mines){
            grid[m[0]][m[1]]=0;
        }
        int max = 0;

        int top[][] = new int[n][n];

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    top[i][j] = grid[i][j];
                }

                else if(grid[i][j]==1){
                    top[i][j] = grid[i-1][j] >0 ? top[i-1][j]+1 : 0;
                    max = 1;
                }
            }
        }

        int down[][] = new int[n][n];

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i==n-1){
                    down[i][j] = grid[i][j];
                }

                else if(grid[i][j]==1){
                    down[i][j] = grid[i+1][j] >0 ? down[i+1][j]+1 : 0;
                    max = 1;
                }
            }
        }

        int left[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                if(j==0){
                    left[i][j] = grid[i][j];
                }

                else if(grid[i][j]==1){
                    left[i][j] = grid[i][j-1] > 0 ? left[i][j-1]+1 : 0;
                    max = 1;
                }
            }
        }

        int right[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=n-2;j>=0;j--){
                if(j==n-1){
                    right[i][j] = grid[i][j];
                }

                else if(grid[i][j]==1){
                    right[i][j] = grid[i][j+1] > 0 ? right[i][j+1]+1 : 0;
                    max = 1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==n-1 || j==0 || j==n-1){

                }else{
                    int ans = Math.min(Math.min(top[i][j],down[i][j]),
                            Math.min(left[i][j],right[i][j]))+1;
                    if(ans>max) {
                        max = ans;
                    }
                }
            }
        }
        return max;
    }
}
