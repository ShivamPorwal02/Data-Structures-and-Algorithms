package Recursion;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        printNQueens(a,"",0);
    }
    public static boolean isItsafe(int[][] a,int row,int col){
        for (int i=row-1,j=col;i>=0 ;i-- ) {
            if(a[i][j]==1){
                return false;
            }
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0 ;i--,j-- ) {
            if(a[i][j]==1){
                return false;
            }
        }
        for (int i=row-1,j=col+1;i>=0&&j<a.length ;i--,j++ ) {
            if(a[i][j]==1){
                return false;
            }
        }
        return true;
    }
    public static void printNQueens(int[][] a, String qsf, int row) {
        if(row==a.length){
            System.out.println(qsf+".");
            return;
        }
        for (int col=0;col<a.length ;col++ ) {
            if(isItsafe(a,row,col)){
                a[row][col]=1;
                printNQueens(a,qsf+row+"-"+col+", ",row+1);
                a[row][col]=0;
            }
        }
    }
}
