package LoveBabbar.Strings;

import java.util.HashMap;
import java.util.Scanner;

public class CommonElementinAllRow {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            for (int j=0;j<m ;j++ ) {
                mat[i][j] = scn.nextInt();
            }
        }
        CommonElement(mat,n,m);
    }
    public static void CommonElement(int[][] mat,int  n,int m){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int j=0;j<m;j++){
            hm.put(mat[0][j],1);
        }
        for(int i=1;i<n;i++){

            for(int j=0;j<m;j++) {
                if (hm.containsKey(mat[i][j]) && hm.get(mat[i][j])==i) {
                    hm.put(mat[i][j], i+1);
                    if(hm.get(mat[i][j])==n){
                        System.out.println(mat[i][j]);
                    }
                }
            }
        }
    }
}

