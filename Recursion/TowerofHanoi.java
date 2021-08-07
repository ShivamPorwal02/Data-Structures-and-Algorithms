package Recursion;

import java.util.Scanner;

public class TowerofHanoi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        tower(n,a,b,c);
    }
    public static void tower(int n,int a,int b,int c){
        if(n==0){
            return;
        }
        tower(n-1,a,c,b);
        System.out.println(n+"["+a+" -> "+c+"]");
        tower(n-1,b,a,c);
    }
}
