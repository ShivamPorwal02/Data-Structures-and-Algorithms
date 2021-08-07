package LoveBabbar.BackTracking;

import java.util.Scanner;

public class LongestPossibleRouteinMatrixinHurdles {
    public static void main(String[] args) {
        max = Integer.MIN_VALUE;
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        maxPath(arr,0,0,1);
        System.out.println(max);
    }
    static int max;
    public static void maxPath(int[][] arr,int i,int j,int move){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!=1) return;
        if(i==arr.length-1 && j==arr[0].length-1){
            if(move>max) max = move;
            return;
        }

        arr[i][j] = 2;
        maxPath(arr,i+1,j,move+1);
        maxPath(arr,i,j+1,move+1);
        maxPath(arr,i-1,j,move+1);
        maxPath(arr,i,j-1,move+1);
        arr[i][j] = 1;
    }
}
//3 10
//        1 1 1 1 1 1 1 1 1 1
//        1 1 0 1 1 0 1 1 0 1
//        1 1 1 1 1 1 1 1 1 1
