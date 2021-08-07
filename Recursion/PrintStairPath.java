package Recursion;

import java.util.Scanner;

public class PrintStairPath {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n,"");

    }
    public static void printStairPaths(int n, String path) {
        if(n==0){
            System.out.println(path);
            return;
        }
        for (int i=1;n-i>=0&&i<=3 ;i++ ) {
            printStairPaths(n-i,path+i);
        }
    }


}
