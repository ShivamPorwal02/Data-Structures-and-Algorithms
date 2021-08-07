package LoveBabbar.BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class TugOfWar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        ArrayList<Integer> lst1 = new ArrayList<>();
        ArrayList<Integer> lst2 = new ArrayList<>();
        tugofWar(arr,lst1,lst2,0,0,0);
        System.out.println(ans);
    }
    static int min = Integer.MAX_VALUE;
    static String ans = "";
    public static void tugofWar(int[] arr, ArrayList<Integer> lst1,ArrayList<Integer> lst2,int sum1,int sum2,int pos){
        if(pos==arr.length){
            int delta = Math.abs(sum1-sum2);
            if(delta<min){
                min = delta;
                ans = lst1+" "+lst2;
                return;
            }
            return;
        }

        if(lst1.size()<(arr.length+1)/2){
            lst1.add(arr[pos]);
            tugofWar(arr,lst1,lst2,sum1+arr[pos],sum2,pos+1);
            lst1.remove(lst1.size()-1);
        }
        if(lst2.size()<(arr.length+1)/2){
            lst2.add(arr[pos]);
            tugofWar(arr,lst1,lst2,sum1,sum2+arr[pos],pos+1);
            lst2.remove(lst2.size()-1);
        }
    }
}
