package LoveBabbar.Strings;

import java.util.HashMap;

public class RomanNumbertoInteger {
    public int romanToDecimal(String s) {
        // code here
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        int num = hm.get(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(hm.get(s.charAt(i))>hm.get(s.charAt(i-1))){
                int x = hm.get(s.charAt(i))-2*hm.get(s.charAt(i-1));
                num+=x;
            }else{
                num+=hm.get(s.charAt(i));
            }
        }
        return num;
    }
}
