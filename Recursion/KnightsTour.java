package Recursion;

import java.util.Scanner;

public class KnightsTour {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        int row = scn.nextInt();
        int col = scn.nextInt();
        printKnightsTour(a,row,col,1);
    }
    public static void printKnightsTour(int[][] a,  int row,int col,int move) {
        if(row<0 || col <0 || row>=a.length || col >=a.length || a[row][col]>0){
            return;
        }
        else if (move==(a.length*a.length)) {
            a[row][col]=move; // 25che move k lia hai ye
            displayBoard(a);
            a[row][col]=0; // jp move daalte hai usko htate jrror hao backrtracking m
            return;
        }
            a[row][col]=move;
            printKnightsTour(a,row-2,col+1,move+1);
            printKnightsTour(a,row-1,col+2,move+1);
            printKnightsTour(a,row+1,col+2,move+1);
            printKnightsTour(a,row+2,col+1,move+1);
            printKnightsTour(a,row+2,col-1,move+1);
            printKnightsTour(a,row+1,col-2,move+1);
            printKnightsTour(a,row-1,col-2,move+1);
            printKnightsTour(a,row-2,col-1,move+1);
            a[row][col]=0; // jo move daalte hai usko htate jrror hao backrtracking m

    }
    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
