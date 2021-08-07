package LoveBabbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FactorialofLargeNumber {
    public static ArrayList<Integer> factorial(int N){
        //code here
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        for(int x = 2; x<=N;x++) {
            int carry = 0;
            int l = lst.size();
            for (int i = 0; i < l; i++) {
                int prdct = lst.get(i) * x + carry;
                lst.set(i, prdct % 10);
                carry = prdct / 10;
            }
            while (carry!=0)
            {
                lst.add(carry % 10);
                carry = carry / 10;
            }
        }
        Collections.reverse(lst);
        return lst;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(factorial(n));
    }
}
