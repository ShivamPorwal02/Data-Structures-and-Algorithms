package StackandQueues;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<n ;j++ ) {
                a[i][j] = scn.nextInt();
            }
        }

        Stack<Integer> st = new Stack<>();
        for (int i=0;i<n ;i++ ) {
            st.push(i);
        }
        while (st.size()>=2){
            int i = st.pop();
            int j= st.pop();

            if(a[i][j]==1){
                // i knows j therefore i cant be celebrity
                st.push(j);
            }else{
                // i doesnt knows j therefore j cant be celebrity
                st.push(i);
            }
        }
        int pot= st.pop();
        for (int i=0;i<a.length;i++){
            if(i!=pot){
                if(a[i][pot]==0 || a[pot][i]==1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);
    }
}
