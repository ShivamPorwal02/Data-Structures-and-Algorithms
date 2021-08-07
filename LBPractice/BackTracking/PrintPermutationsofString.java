package LoveBabbar.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrintPermutationsofString {
    static ArrayList<String> lst = new ArrayList<>();
    public static List<String> find_permutation(String S) {
        // Code here
        lst.clear();
        Permutations(S,"");
        // Collections.sort(lst);
        return lst;

    }

    public static void Permutations(String s,String ans){
        if(s.length()==0){
            lst.add(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            Permutations(s.substring(0,i)+s.substring(i+1),ans+s.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        List<String> lst = find_permutation(s);
        System.out.println(lst);
    }
}
