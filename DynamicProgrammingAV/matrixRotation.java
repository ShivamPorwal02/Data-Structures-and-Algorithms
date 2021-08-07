package DynamicProgrammingAV;

import java.util.Arrays;
import java.util.Scanner;

public class matrixRotation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        int p = scn.nextInt();
        int k =scn.nextInt();
        char c = scn.next().charAt(0);
        int[][] ans= rotate(arr,m,n,p,k,c);
        for(int[] row : ans){
            System.out.println(Arrays.toString(row));
        }

    }
    public static int[][] rotate(int[][] arr,int m,int n,int p,int k,char c){
        if(c == 'R'){
            while(k>0){
                rotateRow(arr,p-1);
                k--;
            }
        }else{
            while(k>0){
                rotateCol(arr,p-1);
                k--;
            }
        }
        return arr;
    }
    public static void rotateRow(int[][] arr,int r){
        int temp = arr[r][0];
        for(int col=1;col<arr[0].length;col++){
            arr[r][col-1] = arr[r][col];
        }
        arr[r][arr[0].length-1] = temp;
    }
    public static void rotateCol(int[][] arr,int c){
        int temp = arr[0][c];
        for(int row=1;row<arr.length;row++){
            arr[row-1][c] = arr[row][c];
        }
        arr[arr.length-1][c] = temp;
    }
}
