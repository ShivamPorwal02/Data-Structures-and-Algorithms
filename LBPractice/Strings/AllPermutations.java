package LoveBabbar.Strings;

import java.util.Scanner;

public class AllPermutations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Permutations(s,"");

    }
    public static void Permutations(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            Permutations(s.substring(0,i)+s.substring(i+1),ans+s.charAt(i));
        }
    }
}
