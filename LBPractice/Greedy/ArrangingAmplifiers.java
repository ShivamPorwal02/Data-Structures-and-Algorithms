package LoveBabbar.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrangingAmplifiers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t>0){
            int n = scn.nextInt();
            Integer[] arr = new Integer[n];
            for (int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            Arrays.sort(arr);

            int cnt1 = 0;
            for(int i=0;i<n;i++){
                if(arr[i]==1){
                    System.out.print("1 ");
                    cnt1++;
                }
            }
            if(n-cnt1==2 && arr[cnt1]==2 && arr[cnt1+1]==3) System.out.print(2+" "+3);
            else{
                for(int i=n-1;i>=0;i--){
                    if(arr[i]!=1) System.out.print(arr[i]+" ");
                }
            }
            t--;
        }
    }
}
