package LoveBabbar.Heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharaters {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        int max = 0;
        int ans = 0;
        Queue<Character> q = new ArrayDeque<>();
        int[] hm = new int[127];
        Arrays.fill(hm,-1);
        for(int i=0;i<s.length();i++){
            if(hm[(int)s.charAt(i)]==1){
                while(q.peek()!=s.charAt(i)){
                    hm[(int)q.peek()]--;
                    q.remove();
                    ans--;
                }
                hm[(int)q.peek()]--;
                q.remove();
                ans--;
                // ye upr wala para ese socho ki beech hai vo like 'c' replace krna hai vo 'bdca' aese hai fir while dekho kaise chlaya hai

                q.add(s.charAt(i));
                ans++;
                hm[(int)s.charAt(i)]++;
                max = Math.max(ans,max);
            }else{
                q.add(s.charAt(i));
                hm[(int)s.charAt(i)]=1;
                ans++;
                max = Math.max(ans,max);
            }
        }
        return max;
    }
}
