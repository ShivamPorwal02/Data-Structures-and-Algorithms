package LoveBabbar.Strings;

import java.util.Scanner;

public class ValidShuffle {
    public static boolean validShuffle(String s1,String s2,String s){
        if(s1.length()+s2.length()!=s.length()){
            return false;
        }
        int i=0;
        int j = 0 ;
        int k=0;
        while(k!=s.length()-1){
            if(i<s1.length() && s1.charAt(i)==s.charAt(k)){
                i++;
            }else if(j<s2.length() && s2.charAt(j)==s.charAt(k)){
                j++;
            }else{
                return false;
            }
            k++;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s = scn.nextLine();
        System.out.println(validShuffle(s1,s2,s));
    }

}
