package LoveBabbar.BackTracking;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    // System.out.println(board[i][j]);
                    if(isSafe(board,i,j)==false) return false;
                }
            }
        }
        return true;
    }
    public boolean isSafe(char[][] board,int row,int col){
        for(int j=0;j<9;j++){
            if(board[row][j]==board[row][col] && col!=j){
                // System.out.println("shivam");
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==board[row][col] && row!=i){
                // System.out.println("shivammmmmmm");
                return false;
            }
        }
        int subi = (row/3)*3;
        int subj = (col/3)*3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+subi][j+subj]==board[row][col] && row!=i+subi && col!=j+subj){
                    System.out.println(row+" "+col);
                    // System.out.println((i+subi)+"shivammmm"+(j+subj));
                    return false;
                }
            }
        }
        return true;
    }
}
