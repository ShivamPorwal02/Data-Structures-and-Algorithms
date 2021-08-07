package LoveBabbar.Strings;

import java.util.HashMap;

public class _1528_LeetCode {
    public String restoreString(String s, int[] indices) {
        HashMap<Integer,Character> hm = new HashMap<>();
        int n = indices.length;
        for(int i=0;i<n;i++){
            hm.put(indices[i],s.charAt(i));
        }
        String s1 = "";
        for(int i=0;i<n;i++){
            s1+=hm.get(i);
        }
        return s1;
    }
}
