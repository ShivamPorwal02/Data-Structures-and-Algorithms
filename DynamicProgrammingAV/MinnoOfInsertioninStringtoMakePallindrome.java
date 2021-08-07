package DynamicProgrammingAV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MinnoOfInsertioninStringtoMakePallindrome {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        int ans = MinInsertion(s1);
        System.out.println(ans);
    }
    public static int MinInsertion(String s1){
        return s1.length()-LPS(s1);
    }
    public static int LPS(String s1){
        String s2 = "";
        for (int i=s1.length()-1;i>=0 ;i-- ) {
            s2+=s1.charAt(i);
        }
        int lcs = LCS(s1,s2,s1.length(),s2.length());
        return lcs;
    }
    public static int LCS(String s1,String s2,int n,int m){
        int[][] dp = new int[n+1][m+1];
        for (int i=0;i<n+1 ;i++ ) {
            for (int j=0;j<m+1 ;j++ ) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<m+1 ;j++ ) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

              // efficient solution //
//    if(strs==null || strs.length == 0){
//        return new ArrayList<List<String>>();
//    }
//    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
//    //Arrays.sort(strs);
//        for (String s:strs) {
//        char[] ca = s.toCharArray();
//        Arrays.sort(ca) ye code m bhi commented hai (sort syd jyda complexity leta hai islia ni kia vaise
//        String keyStr = String.valueOf(ca);
//        if(!map.containsKey(keyStr))
//            map.put(keyStr, new ArrayList<String>());
//        map.get(keyStr).add(s);
//    }
//        return new ArrayList<List<String>>(map.values());
}
