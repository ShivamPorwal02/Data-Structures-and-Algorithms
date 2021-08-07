package LoveBabbar.Strings;

public class WordBreak_79 {
    public boolean exist(char[][] input, String s) {
    for (int i=0;i<input.length ;i++) {
        for (int j=0;j<input[0].length ;j++ ) {
            if(dfs(i,j,0,input,s)){
                return true;
            }
        }
    }
        return false;

}
    public static boolean dfs(int i,int j,int idx,char[][] input,String s){
        if(idx==s.length()-1 && input[i][j] == s.charAt(idx)){
            return true;
        }
        boolean ans = false;
        if(input[i][j]==s.charAt(idx)){
            char c = input[i][j];
            input[i][j] = '$';
            if(j<input[0].length-1){
                if(ans==true){
                    return true;
                }
                ans =  dfs(i,j+1,idx+1,input,s);
            }
            if(j>0){
                if(ans==true){
                    return true;
                }
                ans = dfs(i,j-1,idx+1,input,s);
            }
            if(i<input.length-1){
                if(ans==true){
                    return true;
                }
                ans =  dfs(i+1,j,idx+1,input,s);
            }
            if(i>0){
                if(ans==true){
                    return true;
                }
                ans =  dfs(i-1,j,idx+1,input,s);
            }
            input[i][j] = c;
        }
        return ans;
    }
}
