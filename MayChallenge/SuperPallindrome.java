package MayChallenge;

import java.util.ArrayList;
import java.util.List;

public class SuperPallindrome {
    public int superpalindromesInRange(String left, String right) {

        // VIDEO LINK
//        https://youtu.be/-jIP5SLitbM

        List<Long> lst = new ArrayList<>();
        long leftLong = Long.parseLong(left);
        long rightLong = Long.parseLong(right);

        int cnt = 0 ;
        for(long i=1;i<10;i++){
            lst.add(i);
        }
        // [1, 10^18]
        // left Part is upto 10^4
        // right Part upto 10^4

        for(long i=1;i<10000;i++){
            String leftPart = i+"";
            String rightPart = new StringBuilder(leftPart).reverse().toString();
            lst.add(Long.parseLong(leftPart+rightPart)); // 10^4

            for(int digit = 0 ; digit<10;digit++){
                lst.add(Long.parseLong(leftPart+digit+rightPart));  // 10^9;
            }
        }
        for(long no : lst){
            long sq = no*no;
            if(sq>=leftLong && rightLong>=sq && isPallindrome(sq)){
                cnt++;
            }
        }
        return cnt;
    }
    public static boolean isPallindrome(long a){
        String s = a+"";
        int i=0;
        int j= s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
