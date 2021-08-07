package RecursionAV;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateAllBalancedParentheses {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ans = allParenthese(n);
        System.out.println(ans);
    }
    public static ArrayList<String> allParenthese(int n){
        int open = n;
        int close = n;
        ArrayList<String> lst = new ArrayList<>();
        generateAll(open,close,"",lst);
        return lst;
    }
    public static void generateAll(int o,int c,String output,ArrayList<String> lst){
        if(o==0 && c == 0){
            lst.add(output);
            return;
        }
        if(o!=0){
            generateAll(o-1,c,output+"(",lst);
        }
        if(c>o){
            generateAll(o,c-1,output+")",lst);
        }
    }
}
