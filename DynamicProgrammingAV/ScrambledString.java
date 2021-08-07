package DynamicProgrammingAV;

import java.util.HashMap;
import java.util.Scanner;

public class ScrambledString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        if(s1.length()!=s2.length()){
            System.out.println("false");
        }
        if(s1=="" && s2==""){
            System.out.println("true");
        }
        boolean ans = scrambledString(s1,s2);
        System.out.println(ans);

        boolean ans2 = scrambledStringMemo(s1,s2);
        System.out.println(ans2);
    }
    public static boolean scrambledString(String s1,String s2){
        if(s1.equals(s2)){
            return true;
        }
        // equal to 1 wala case islia hai ki agr upr agr 1 length ki string barabr ni hui to obvioo ni hai vo scrambled
        if(s1.length()<=1){
            return false;
        }
        int n = s1.length();
        boolean flag = false;
        for (int i=1;i<=s1.length()-1 ;i++ ) {
            // case 1 when swap is done
            boolean flag1 = scrambledString(s1.substring(0,i),s2.substring(n-i,n)) &&
                            scrambledString(s1.substring(i,n),s2.substring(0,n-i));
            // case 2 when swap is not done
            boolean flag2 = scrambledString(s1.substring(0,i),s2.substring(0,i)) &&
                    scrambledString(s1.substring(i,n),s2.substring(i,n));
            if(flag1==true || flag2==true){
                flag = true;
                break;
            }
        }
        return flag;
    }
    // MEMORIZATION(BOTTOM UP)
    static HashMap<String,Boolean> mp = new HashMap<>();
    public static boolean scrambledStringMemo(String s1,String s2){
        if(s1.equals(s2)){
            return true;
        }
        if(s1.length()<=1){
            return false;
        }
//        int[] a1 = new int[26];
//        int[] a2 = new int[26];
//        for(int i=0;i<s1.length();i++){
//            a1[s1.charAt(i)-'a']++;
//            a2[s2.charAt(i)-'a']++;
//        }
//        for(int i=0;i<26;i++){
//            if(a1[i]!=a2[i]){
//                return false;
//            }
//        }
        // ye upr ka more optimize krdega ki agr dono m same number of character ni hai to aage check hi ni krro

        String str = s1+" "+s2;
        if(mp.containsKey(str)){
            return mp.get(str);
        }
        boolean flag = false;
        int n = s1.length();
        for (int i=1;i< n;i++ ) {
            // case 1 when swap is done
            boolean flag1 = scrambledString(s1.substring(0,i),s2.substring(n-i,n)) &&
                    scrambledString(s1.substring(i,n),s2.substring(0,n-i));
            // case 2 when swap is not done
            boolean flag2 = scrambledString(s1.substring(0,i),s2.substring(0,i)) &&
                    scrambledString(s1.substring(i,n),s2.substring(i,n));
            if(flag1==true || flag2==true){
                flag = true;
                break;
            }
        }
        mp.put(str,flag);
        return flag;
    }
}
