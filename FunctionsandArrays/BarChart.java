import java.util.Scanner;

public class BarChart {
    public static int maximum(int[] a){
        int max = Integer.MIN_VALUE;
        for (int i=0;i<a.length ;i++ ) {
            if(a[i]>=max){
                max=a[i];
            }
        }
        return max;
    }
    public static void barChart(int[] a){
        for (int i=maximum(a);i>=1 ;i-- ) {
            for (int j=0;j<a.length;j++){
                if (a[j]>=i) {
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<a.length ;i++ ) {
            a[i]=scn.nextInt();
        }
        barChart(a);
    }

}

