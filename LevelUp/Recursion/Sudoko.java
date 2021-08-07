package LevelUp.Recursion;

import java.util.*;

public class Sudoko {
    public static void main(String[] ar){
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
    }
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(int[][] board, int i, int j) {
        if(i==board.length){
            display(board);
            return;
        }
        int ni = 0;
        int nj=0;
        if(j==board[0].length-1){
            ni=i+1;
            nj = 0;
        }else{
            ni = i;
            nj = j+1;
        }
        if(board[i][j]!=0){
            solveSudoku(board,ni,nj);
        }else{
            for(int pos = 1;pos<=9;pos++){
                if(isValid(board,i,j,pos)==true){
                    board[i][j] = pos;
                    solveSudoku(board,ni,nj);
                    board[i][j] = 0;
                }
            }
        }
    }
    public static boolean isValid(int[][] board,int x,int y,int val){
        for(int j=0;j<board[0].length;j++){
            if(board[x][j]==val){
                return false;
            }
        }
        for(int i = 0;i<board.length;i++){
            if(board[i][y]==val){
                return false;
            }
        }
        int smi = 3*(x/3);
        int smj = 3*(y/3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[smi+i][smj+j]==val){
                    return false;
                }
            }
        }
        return true;
    }
}
