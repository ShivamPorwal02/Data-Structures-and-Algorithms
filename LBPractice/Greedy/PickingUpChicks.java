package LoveBabbar.Greedy;

import java.util.Scanner;

public class PickingUpChicks {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int j = 0;
        while (t>0){
            j++;
            int n  = scn.nextInt();
            int k = scn.nextInt();
            int b = scn.nextInt();
            int time = scn.nextInt();

            int[] x = new int[n];
            int[] v = new int[n];

            for(int i=0;i<n;i++){
                x[i] = scn.nextInt();
            }
            for (int i=0;i<n;i++){
                v[i] = scn.nextInt();
            }

            int cnt = 0;
            int swaps = 0;
            int not_possible = 0;

            for(int i=n-1;i>=0;i--){
                int distance_needed = b-x[i];
                int distance_possible = v[i]*time;

                if(distance_possible>=distance_needed){
                    cnt++;
                    if(not_possible>0){
                        swaps+=not_possible;
                    }
                }else not_possible++;
                if(cnt>=k) break;
            }
            if(cnt>=k){
                System.out.println("Case #"+ j +": " + swaps);
            }else System.out.println("Case #"+ j +": " + "IMPOSSIBLE");


            t--;
        }
    }
}
