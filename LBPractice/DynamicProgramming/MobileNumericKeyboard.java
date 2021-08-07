package LoveBabbar.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MobileNumericKeyboard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getCount(n));
    }
    public static long getCount(int n)
    {
        // Your code goes here

        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();

        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(2);
        lst.add(4);

        hm.put(1,lst);

        lst = new ArrayList<>();
        lst.add(1);
        lst.add(3);
        lst.add(5);

        hm.put(2,lst);

        lst = new ArrayList<>();
        lst.add(2);
        lst.add(6);

        hm.put(3,lst);

        lst = new ArrayList<>();

        lst.add(1);
        lst.add(7);
        lst.add(5);


        hm.put(4,lst);


        lst = new ArrayList<>();

        lst.add(2);
        lst.add(4);
        lst.add(6);
        lst.add(8);


        hm.put(5,lst);



        lst = new ArrayList<>();

        lst.add(3);
        lst.add(5);
        lst.add(9);


        hm.put(6,lst);


        lst = new ArrayList<>();

        lst.add(4);
        lst.add(8);


        hm.put(7,lst);


        lst = new ArrayList<>();

        lst.add(5);
        lst.add(7);
        lst.add(0);
        lst.add(9);

        hm.put(8,lst);


        lst = new ArrayList<>();

        lst.add(6);
        lst.add(8);

        hm.put(9,lst);


        lst = new ArrayList<>();

        lst.add(8);

        hm.put(0,lst);

        int[] dp = new int[10];
        Arrays.fill(dp,1);
// 		if(n==1)
        for(int i=2;i<=n;i++){
            int[] dup = new int[10];
            for(int j=0;j<10;j++){

                int size = hm.get(j).size();
                dup[j]+=dp[j];
                for(int k = 0;k<size;k++){
                    dup[j]+=dp[hm.get(j).get(k)];
                }
//                System.out.println(dup[j]);
            }
            for(int x=0;x<10;x++){
                dp[x] = dup[x];
            }
        }
        int sum = 0;
        for(int i=0;i<10;i++){
            sum+=dp[i];
        }
        return sum;
    }
}
