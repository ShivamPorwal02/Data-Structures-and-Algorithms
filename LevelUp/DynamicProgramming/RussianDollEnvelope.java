package LevelUp.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class RussianDollEnvelope {
    public static class Bridge implements Comparable<Bridge>{
        int n;
        int r;
        Bridge(int n,int r){
            this.n = n;
            this.r = r;
        }
        public int compareTo(Bridge o){
            return this.n-o.n;
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        Bridge[] bridge = new Bridge[n];

        for(int i=0;i<n;i++){
            String temp = scn.nextLine();
            String[] arr = temp.split(" ");
            int nr = Integer.parseInt(arr[0]);
            int r = Integer.parseInt(arr[1]);
            bridge[i] = new Bridge(nr,r);
        }

        Arrays.sort(bridge);

        int[] dp = new int[n];
        int omax = 0;
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(bridge[i].n>bridge[j].n&&bridge[i].r>bridge[j].r){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
            if(dp[i]>omax){
                omax = dp[i];
            }
        }
        System.out.println(omax);
    }
}
