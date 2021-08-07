package LoveBabbar.Greedy;

import java.util.Scanner;

public class WineTradinginGergovia {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        while(n!=0){

            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            long work = 0;
            for(int i=1;i<n;i++){
                arr[i]+=arr[i-1];
                work+=Math.abs(arr[i-1]);
            }
            System.out.println(work);
            n = scn.nextInt();
        }
        return;
    }
}
