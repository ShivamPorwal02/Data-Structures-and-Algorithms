package LoveBabbar.BackTracking;

import java.util.ArrayList;

public class NQueen_1 {
    static ArrayList<ArrayList<Integer>> ans;
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        int[][] arr = new int[n][n];
        ArrayList<Integer> lst = new ArrayList<>();
        ans = new ArrayList<>();
        queen(arr,0,lst);

        return ans;
    }

    static public boolean isSafe(int[][] arr,int row,int col){
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
    static void queen(int[][] arr, int row, ArrayList<Integer> lst){
        if(row==arr.length){
            ArrayList<Integer> lst1 = new ArrayList<>();
            // agr hm lst daalte kyuki hm baad m usse backtraking m khali krre hai to khali hi aajata
            for(int x : lst) lst1.add(x);
            ans.add(lst1);
            lst = new ArrayList<>();
            return;
        }
        for(int col=0;col<arr.length;col++){
            if(isSafe(arr,row,col)){
                arr[row][col]=1;
                lst.add(col+1);
                queen(arr,row+1,lst);
                // System.out.println(lst);
                arr[row][col]=0;
                lst.remove(lst.size()-1);
            }
        }
    }
}
