package LoveBabbar.Strings;

import java.util.Scanner;

public class CountStringin2dMatrix {
    public static void main(String[] args) {
        String s= "MAGIC";
        char input[][] = {
            {'B','B','A','B','A','M'},
            {'C','B','M','B','B','A'},
            {'I','B','A','B','B','G'},
            {'G','O','Z','B','B','I'},
            {'A','B','C','B','B','C'},
            {'M','C','I','G','A','M'}
        };
        int ans = 0;
        for (int i=0;i<input.length ;i++) {
            for (int j=0;j<input[0].length ;j++ ) {
                ans+=dfs(i,j,0,input,s);
            }
        }
        System.out.println(ans);

    }
    public static int dfs(int i,int j,int idx,char[][] input,String s){
        if(idx==s.length()-1 && input[i][j] == s.charAt(idx)){
            return 1;
        }
        int ans = 0;
        if(input[i][j]==s.charAt(idx)){
            char c = input[i][j];
            input[i][j] = '$';
            if(j<input[0].length-1){
                ans+=dfs(i,j+1,idx+1,input,s);
            }
            if(j>0){
                ans+=dfs(i,j-1,idx+1,input,s);
            }
            if(i<input.length-1){
                ans+=dfs(i+1,j,idx+1,input,s);
            }
            if(i>0){
                ans+=dfs(i-1,j,idx+1,input,s);
            }
            input[i][j] = c;
        }
        return ans;
    }
}
