package RecursionAV;

import java.util.Scanner;

public class TowerofHanoi {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        towerofHanoi(1,3,2,n);
    }
    public static void towerofHanoi(int sr,int dest,int help,int n){
        if(n==1){
            System.out.println("Moving "+n+" from "+sr+" to "+dest);
            return;
        }
        towerofHanoi(sr,help,dest,n-1);
        System.out.println("Moving "+n+" from "+sr+" to "+dest);
        towerofHanoi(help,dest,sr,n-1);
    }
}
