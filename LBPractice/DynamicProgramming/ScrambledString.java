package LoveBabbar.DynamicProgramming;

import java.util.HashMap;

public class ScrambledString {
    HashMap<String,Boolean> hm = new HashMap<>();
    public boolean isScramble(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1!=n2) return false;

        if(s1.equals(s2)) return true;

        if(s1.length()<1 || s2.length()<1) return false;

        String str = s1+" "+s2;
        if(hm.containsKey(str)) return hm.get(str);

        boolean flag = false;
        int n = s1.length();
        for(int i=1;i<s1.length()-1;i++){
            // case 1 when swap is done
            boolean flag1 = isScramble(s1.substring(0,i),s2.substring(n-i,n)) &&
                            isScramble(s1.substring(i,n),s2.substring(0,n-i));

            boolean flag2 = isScramble(s1.substring(0,i),s2.substring(0,i))&&
                            isScramble(s1.substring(i,n),s2.substring(i,n));

            if(flag1 || flag2){
                flag = true;
                break;
            }
        }
        hm.put(str,flag);
        return flag;
    }
}
