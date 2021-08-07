package LoveBabbar.SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class BishuAndSoldiers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] soldiers = new int[n];
        for (int i=0;i<n ;i++ ) {
            soldiers[i] = scn.nextInt();
        }
        int q = scn.nextInt();
        int[] power = new int[q];
        for (int i=0;i<q;i++ ) {
            power[i] = scn.nextInt();
        }
        kill(soldiers,power,q);
    }
    public static void kill(int[] arr,int[] power,int q){
        Arrays.sort(arr);
        int sum = 0;
        int cnt = 0;
        for(int i=0;i<q;i++){
            sum=0;
            cnt = 0;
            int j=0;
            while(j<arr.length && power[i]>=arr[j]) {
                sum += arr[j];
                cnt++;
                j++;
            }
            System.out.println(cnt+" "+sum);
        }
    }
}
