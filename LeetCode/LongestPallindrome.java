package LeetCode;

import java.util.HashMap;

public class LongestPallindrome {
    int[][] dp;
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        // for( : )
        int cnt = 0;
        int ones = 0;
        for(Character c : hm.keySet()){
            if(hm.get(c)%2==1) ones += 1;
        }
        return s.length()-ones+(ones>0 ? 1 : 0);
    }
    // ekk pura odd le skte hai aur baaki sbm se 1 char unka chhd k le skte hai
    // btw isse arr[26] bna k krna chahia
}
