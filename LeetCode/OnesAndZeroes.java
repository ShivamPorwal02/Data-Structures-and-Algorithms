package LeetCode;

public class OnesAndZeroes {
    class Pair{
        int zero;
        int ones;
        Pair(int zero,int ones){
            this.zero = zero;
            this.ones = ones;
        }
    }
    public int findMaxForm(String[] arr, int m, int n) {
        int[][][] dp = new int[arr.length+1][n+1][m+1];

        for(int i=1;i<arr.length+1;i++){
            Pair res = isCandidate(arr[i-1],n,m);
            for(int x=0;x<n+1;x++){
                for(int y=0;y<m+1;y++){
                    if(res.ones<=x && res.zero<=y){
                        dp[i][x][y] = Math.max(1+dp[i-1][x-res.ones][y-res.zero],dp[i-1][x][y]);
                    }else dp[i][x][y] = dp[i-1][x][y];
                }
            }
        }
        return dp[arr.length][n][m];
    }
    public Pair isCandidate(String s,int n,int m){
        int zero = 0;
        int ones = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zero++;
            }else{
                ones++;
            }
        }
        return new Pair(zero,ones);
    }
}
