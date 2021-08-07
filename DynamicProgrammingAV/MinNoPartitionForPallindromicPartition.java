package DynamicProgrammingAV;

import java.util.Arrays;
import java.util.Scanner;

public class MinNoPartitionForPallindromicPartition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        int ans = MinPartition(s1,0,s1.length()-1);
        System.out.println(ans);

        for (int[] row: dp ) {
            Arrays.fill(row,-1);
        }
        int ans1 = MinPartitionMemo(s1,0,s1.length()-1);
        System.out.println(ans);

        for (int[] row: dp1 ) {
            Arrays.fill(row,-1);
        }
        int ans2 = MCMoptimize(s1,0,s1.length()-1);
        System.out.println(ans2);
    }
    public static int MinPartition(String s1,int i,int j){
        if(i>=j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(isPallindrome(s1,i,j)){
            return 0;
        }
        for (int k=i;k<=j-1 ;k++ ) {
            int tempans = MinPartition(s1,i,k)+MinPartition(s1,k+1,j)+1;
            min = Math.min(min,tempans);
        }
        return min;
    }
    public static boolean isPallindrome(String s1,int i,int j){
        while(i<j){
            if(s1.charAt(i)!=s1.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // MEMORIZATION
    static int[][] dp = new int[1001][1001];
    public static int MinPartitionMemo(String s1,int i,int j){
        if(i>=j){
            return 0;
        }
        if(isPallindrome(s1,i,j)){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        for (int k=i;k<=j-1 ;k++ ) {
            int tempans = MinPartitionMemo(s1,i,k)+MinPartition(s1,k+1,j)+1;
            min = Math.min(tempans,min);
        }
        return dp[i][j] = min;
    }
    // OPTIMIZATION
    static int[][] dp1 = new int[1001][1001];
    public static int MCMoptimize(String s,int i,int j){
        if(i>=j){
            return 0;
        }
        if(isPallindrome(s,i,j)){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(dp1[i][j]!=-1){
            return dp1[i][j];
        }
        int left = 0;
        int right = 0;
        for (int k=i;k<=j-1;k++){
            if(dp1[i][k]!=-1){
                left = dp1[i][k];
            }else{
                left = MCMoptimize(s,i,k);
                dp1[i][k] = left;
            }
            if(dp1[k+1][j]!=-1){
                right = dp1[k+1][j];
            }else{
                right = MCMoptimize(s,k+1,j);
                dp1[k+1][j] = right;
            }
            int tempans = left+right+1;
            min = Math.min(tempans,min);
        }
        return dp1[i][j] = min;
    }
}
