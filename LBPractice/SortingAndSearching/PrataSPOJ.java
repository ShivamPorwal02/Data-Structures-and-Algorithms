package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class PrataSPOJ {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int prata = scn.nextInt();
        int n = scn.nextInt();
        int[] rank = new int[n];
        for (int i=0;i<n ;i++ ) {
            rank[i] = scn.nextInt();
        }
        int ans = days(rank,prata);
        System.out.println(ans);
    }
    public static int days(int[] arr,int prata){
        int min = Integer.MAX_VALUE;
        for (int i=0;i<arr.length ;i++ ) {
            if(arr[i]<min){
                min = arr[i];
            }
        }
//        System.out.println(min);
//        System.out.println(noOfDays(min,prata));
        int i=0;
        int j = noOfDays(min,prata);
        int best = 0;
        while(i<=j){
            int mid = (i+j)/2;

            if(isTotal(arr,mid,prata)){
                best = mid;
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return best;
    }
    public static boolean isTotal(int[] arr,int days,int prata){
        int prate = 0;
        for(int i=0;i<arr.length;i++){
            prate+=noOfPrata(arr[i],days);
        }
        if(prate<prata){
            return false;
        }else{
            return true;
        }
    }
    public static int noOfPrata(int rank,int days){
        if(days<rank){
            return 0;
        }
        int cnt = 0;
        int multiplier = rank;
        int num = 2;
        int nofdays = multiplier;
        while(nofdays<=days){
            cnt++;
            multiplier = rank*num;
//            System.out.println(multiplier+" ko");
            num++;
            nofdays+=multiplier;
//            System.out.println(nofdays+" days");
        }
        return cnt;
    }
    public static int noOfDays(int rank,int prata){
        int cnt = 0;
        int ans = rank;
        int x = 1;
        int nofdays = 0;
        while(cnt!=prata){
            cnt++;
            ans = rank*x;
            nofdays+=ans;
            x++;
        }
        return nofdays;
    }
}
