import java.io.*;
import java.util.*;

public class HighestFrequencyCharacter {

    public static void main(String[] args) throws Exception {
        HashMap<Character,Integer> hm = new HashMap<>();
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        for(int i=0;i<str.length();i++){
            if(hm.containsKey(str.charAt(i))){
                int val = hm.get(str.charAt(i));
                val+=1;
                hm.put(str.charAt(i),val);
            }else{
                hm.put(str.charAt(i),1);
            }
        }
        int max = Integer.MIN_VALUE;
        Character ch=str.charAt(0);
        // System.out.println(hm);
        for(Character key : hm.keySet()){
            if(hm.get(key)>max){
                max = hm.get(key);
                ch=key;
            }
        }
        System.out.println(ch);
    }

}
