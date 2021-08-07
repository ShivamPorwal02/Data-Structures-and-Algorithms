package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> ans = getMazePaths(1,1,n,m);
        System.out.println(ans);
    }
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> x = new ArrayList<>();
            x.add("");
            return x;
        }
        ArrayList<String> hor = new ArrayList<>();
        ArrayList<String> ver = new ArrayList<>();
        if(sc<dc){
            hor=getMazePaths(sr,sc+1,dr,dc);
        }
        if(sr<dr){
            ver = getMazePaths(sr+1,sc,dr,dc);
        }
        ArrayList<String> my = new ArrayList<>();
        for (String str: hor ) {
            my.add("h"+str);
        }
        for (String str: ver ) {
            my.add("v"+str);
        }
        return my;
    }
}
