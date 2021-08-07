package LevelUp.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class NonOverLappingBridges {
    public static class Bridges implements Comparable<Bridges>{
        int n;
        int s;
        Bridges(int n,int s){
            this.n = n;
            this.s = s;
        }
        public int compareTo(Bridges o){
            if(this.n!=o.n){
                return this.n-o.n;
            }else{
                return this.s - o.s;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        Bridges[] bridge = new Bridges[n];

        for(int i=0;i<n;i++){
            String line = scn.nextLine();
            String[] arr = line.split(" ");
            int nr = Integer.parseInt(arr[0]);
            int r = Integer.parseInt(arr[1]);
            bridge[i] = new Bridges(nr,r);
        }
        Arrays.sort(bridge);
        int omax= 0 ;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(bridge[i].s>=bridge[j].s){
                    if(dp[j]>max){
                        max=dp[j];
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
