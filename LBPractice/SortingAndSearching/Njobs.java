package LoveBabbar.SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Njobs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] jobs = new int[n];
        for (int i=0;i<n ;i++ ) {
            jobs[i] = scn.nextInt();
        }
        int mem = scn.nextInt();
        int[] skill = new int[mem];
        int[] end = new int[mem];
        for (int i=0;i<mem ;i++ ) {
            skill[i] =scn.nextInt();
        }
        for (int i=0;i<mem ;i++ ) {
            end[i] = scn.nextInt();
        }
        int ans = shift(jobs,skill,end);
        System.out.println(ans);
    }
    public static int shift(int[] jobs,int[] skill,int[] end){
        int[][] mix = new int[skill.length][end.length];
        for(int i=0;i<skill.length;i++){
            mix[0][i] = skill[i];
        }
        for(int i=0;i<skill.length;i++) {
            mix[1][i] = end[i];
        }
        int[] x = jobs;
        Arrays.sort(x);
        int[] y = skill;
        Arrays.sort(y);
        if(x[jobs.length-1]>y[skill.length-1]){
            return -1;
        }
        Arrays.sort(mix,(a,b)->b[0]-a[0]);
        for (int i=0;i<2;i++ ) {
            for (int j=0;j<2;j++ ) {
                System.out.print(mix[i][j]+" ");
            }
            System.out.println();
        }
        int cnt = 0;
        for (int i=0;i<jobs.length ;i++ ) {
            int j=0;
            while(mix[1][j]<jobs[i]){
                j++;
            }
            int skills = mix[1][j];
            int endu = mix[0][j];
            while(endu>0 && skills>jobs[i]){
                i++;
                endu--;
            }
            cnt++;
        }
        return cnt;
    }
}
