package TimeandSpaceComplexity;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<a.length ;i++ ) {
            a[i]=scn.nextInt();
        }
        for (int i =0 ;i<a.length-1 ;i++ ) {
            for (int j=0;j<a.length-i-1 ;j++ ) {
                System.out.println("Comparing "+ a[j+1]+ " and "+ a[j]);
                if(a[j]>a[j+1]){
                    System.out.println("Swapping "+ a[j+1]+ " and "+ a[j]);
                    int temp = a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
        for (int i=0;i<a.length ;i++ ) {
                System.out.println(a[i]);
        }
    }
}
