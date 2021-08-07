package Recursion;

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<m ;j++ ) {
                a[i][j]=scn.nextInt();
            }
        }
        boolean[][] b = new boolean[n][m];
        floodfill(a,0,0,"",b);
    }
    public static void floodfill(int[][] a, int row, int col, String psf, boolean[][] visited) {
        if(row<0 || col<0 || row>=a.length || col >=a[0].length || a[row][col]==1 || visited[row][col] == true){
            return;
        }
        if (row == a.length-1 && col == a[0].length-1) {
            System.out.println(psf);
        }
        visited[row][col] = true;
        floodfill(a,row-1,col,psf+"t",visited);
        floodfill(a,row,col-1,psf+"l",visited);
        floodfill(a,row+1,col,psf+"d",visited);
        floodfill(a,row,col+1,psf+"r",visited);
        visited[row][col] = false;
    }
}
