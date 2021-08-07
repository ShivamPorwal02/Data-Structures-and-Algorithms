package LevelUp.Recursion;

public class SolveSoduku {
    static boolean SolveSudoku(int board[][])
    {
        boolean ans1 = solvesudoku(board,0,0);
        return ans1;
    }

    //Function to print grids of the Sudoku.
    static void printGrid (int board[][])
    {
        // add your code here
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
        }
    }
    public static boolean solvesudoku(int[][] board, int i, int j) {
        if(i==board.length){
            return true;
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
            if(solvesudoku(board,ni,nj)) return true;
        }else{
            for(char pos = 1;pos<=9;pos++){
                if(isValid(board,i,j,pos)==true){
                    board[i][j] = pos;
                    if(solvesudoku(board,ni,nj)) return true;
                    else board[i][j] = 0;
                }
            }
        }
        return false;
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
