package LevelUp.Recursion;

import java.util.Scanner;

public class NQueensBranchandBound {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];

        printNQueen(board,"",0,cols,ndiag,rdiag);
    }
    public static void printNQueen(boolean[][] board,String qsf,int row,boolean[] cols,boolean[] ndiag,boolean[] rdiag){
        if(row==board.length){
            System.out.println(qsf+".");
            return;
        }

        for(int col=0;col<board.length;col++){
            if(cols[col]==false && ndiag[row+col]==false &&
                    rdiag[row-col+board.length-1]==false){
                board[row][col] = true;
                cols[col] = true;
                ndiag[row+col]=true;
                rdiag[row-col+board.length-1]=true;
                printNQueen(board,qsf+row+"-"+col+", ",row+1,cols,ndiag,rdiag);
                board[row][col] = false;
                cols[col] = false;
                ndiag[row+col]=false;
                rdiag[row-col+board.length-1]=false;
            }
        }

    }

}
