package LoveBabbar.BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class PrintPathsFromTopLefttoBottomRight {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        int cnt = 1;
        for(int i=0;i<m;i++){
            for (int j=0;j<n ;j++ ) {
                arr[i][j] = cnt;
                cnt++;
            }
        }
        for(int i=0;i<m;i++) System.out.println(Arrays.toString(arr[i]));
        printPaths(arr,0,0,"");
    }
    public static void printPaths(int[][] arr,int i,int j,String psf){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0) return ;

        if(i==arr.length-1 && j==arr[0].length-1){
            psf+=(arr[i][j]);
            System.out.println(psf);
            return;
        }
        psf+=(arr[i][j]);
        int temp = arr[i][j];
        arr[i][j] = 0;
        printPaths(arr,i+1,j,psf+" ");
        printPaths(arr,i,j+1,psf+" ");
        arr[i][j] = temp;
    }
}
