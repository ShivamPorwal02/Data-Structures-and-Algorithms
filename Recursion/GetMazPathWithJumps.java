package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazPathWithJumps {
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

        ArrayList<String> my = new ArrayList<>();
        for (int i=1;i<=dc-sc ;i++ ) {
            ArrayList<String> ver  = getMazePaths(sr,sc+i,dr,dc);
            for(String str: ver){
                my.add("h"+i+str);
            }
        }
        for (int i=1;i<=dr-sr;i++ ) {
            ArrayList<String> hor = getMazePaths(sr+i,sc,dr,dc);
            for(String str: hor){
                my.add("v"+i+str);
            }
        }
        for (int i=1;i<=dr-sr && i<=dc-sc ;i++ ) {
            ArrayList<String> dia = getMazePaths(sr+i,sc+i,dr,dc);
            for(String str: dia){
                my.add("d"+i+str);
            }
        }
        return my;
    }
}
