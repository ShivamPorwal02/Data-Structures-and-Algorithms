package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class PaintHouseOfficial {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][3];
        for (int i=0;i<a.length ;i++ ) {
            for (int j=0;j<a[0].length ;j++ ) {
                a[i][j] = scn.nextInt();
            }
        }
        int red = a[0][0];
        int blue = a[0][1];
        int green = a[0][2];
        for (int i=1;i<a.length ;i++) {
            int nred = Math.min(blue,green)+a[i][0];
            int nblue= Math.min(red,green)+a[i][1];
            int ngreen = Math.min(red,blue)+a[i][2];

            red = nred;
            blue =nblue;
            green = ngreen;
        }
        System.out.println((Math.min(Math.min(red,blue),green)));
    }
}
