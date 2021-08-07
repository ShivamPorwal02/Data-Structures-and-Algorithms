package LoveBabbar.BackTracking;

import java.util.Scanner;

public class ShortestSafeRouteinPathWithLandmines {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i=0;i<m ;i++ ) {
            for (int j=0;j<n ;j++ ) {
                arr[i][j] = scn.nextInt();
            }
        }
        for(int i=0;i<arr.length;i++){
            shortestPath(arr,i,0,0);
        }
//        shortestPath(arr,0,0,1);
        System.out.println(min);
    }
    static int min = Integer.MAX_VALUE;
    public static void shortestPath(int[][] arr,int i,int j,int move){
//        System.out.println(i+" "+j);
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0 || arr[i][j]==2){
            return;
        }
        if(i-1>=0 && arr[i-1][j]==0) return;
        if(j-1>=0 && arr[i][j-1]==0) return;

        if(i+1<arr.length-1 && arr[i+1][j]==0) return;
        if(j+1<arr[0].length-1 && arr[i][j+1]==0) return;

        if(j==arr[0].length-1){
            if(move<min) min = move;
            return;
        }
        arr[i][j] = 2;
        shortestPath(arr,i+1,j,move+1);
        shortestPath(arr,i,j+1,move+1);
        shortestPath(arr,i-1,j,move+1);
        shortestPath(arr,i,j-1,move+1);
        arr[i][j] = 1;
    }
}
//12 10
//1 1 1 1 1 1 1 1 1 1
//1 0 1 1 1 1 1 1 1 1
//1 1 1 0 1 1 1 1 1 1
//1 1 1 1 0 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 0 1 1 1 1
//1 0 1 1 1 1 1 1 0 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//0 1 1 1 1 0 1 1 1 1
//1 1 1 1 1 1 1 1 1 1
//1 1 1 0 1 1 1 1 1 1
