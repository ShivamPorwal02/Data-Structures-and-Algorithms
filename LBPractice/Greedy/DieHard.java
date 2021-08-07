package LoveBabbar.Greedy;

import java.util.Scanner;

public class DieHard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int[][] medium = new int[3][2];
        medium[0][0] = 3;
        medium[0][1] = 2;
        medium[1][0] = -5;
        medium[1][1] = -10;
        medium[2][0] = -20;
        medium[2][1] = 5;
        while(t>0){
            int h = scn.nextInt();
            int a = scn.nextInt();
            int sec = 0;

            while(h>0 && a>0){
                if(sec%2==0){
                    h = h + medium[0][0];
                    a = a + medium[0][1];
                    sec++;
                    continue;
                }
                if(h+medium[1][0]>0 && a+medium[1][1]>0){
                    h = h+medium[1][0];
                    a = a+medium[1][1];
                }else{
                    h = h+medium[2][0];
                    a = a+medium[2][1];
                }
                if(h>0 && a>0) sec++;
            }
            System.out.println(sec);
            t--;
        }
    }
}
