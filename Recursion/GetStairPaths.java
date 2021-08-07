package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
    }
    public static ArrayList<String> getStairPaths(int n){
        if(n==0){
            ArrayList<String> x = new ArrayList<>();
            x.add("");
            return x;
        }
        if(n<0){
            ArrayList<String> y = new ArrayList<>();
            return y;
        }
        ArrayList<String> path1 = getStairPaths(n-1);
        ArrayList<String> path2 = getStairPaths(n-2);
        ArrayList<String> path3 = getStairPaths(n-3);
        ArrayList<String> path = new ArrayList<>();
        for(String str: path1){
            path.add(1+str);
        }
        for(String str: path2){
            path.add(2+str);
        }
        for(String str: path3){
            path.add(3+str);
        }
        return path;
    }
}
