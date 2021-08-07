package LoveBabbar.BackTracking;

public class NQueens_2 {
    public int totalNQueens(int n) {
        if(n==1) return 1;
        cnt = 0;
        int[][] arr = new int[n][n];
        queen(arr,0);
        return cnt;
    }
    static int cnt;
    public boolean isSafe(int[][] arr,int row,int col){
        // u don't need to check below row waale kuki wha to dla hi ni hai abhi
        // na hi aage wale
        for(int i = row-1;i>=0;i--){
            if(arr[i][col]==1) return false;
        }
        for(int j=col-1;j>=0;j--){
            if(arr[row][j]==1) return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(arr[i][j]==1) return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<arr.length;i--,j++){
            if(arr[i][j]==1) return false;
        }
        return true;
    }
    public void queen(int[][] arr,int row){
        if(row==arr.length){
            // for(int[] x : arr) System.out.println(Arrays.toString(x));
            // System.out.println("Shivam");
            cnt++;
            return;
        }
        for(int col=0;col<arr.length;col++){
            if(isSafe(arr,row,col)){
                arr[row][col]=1;
                queen(arr,row+1);
                arr[row][col]=0;
            }
        }
    }
}
