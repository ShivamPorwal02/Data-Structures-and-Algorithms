package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class PaintHouseManyColors {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int a[][] = new int[n][k];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<k ;j++ ) {
                a[i][j] = scn.nextInt();
            }
        }

        // N3 ka tareeka hai ye //

//        int[][] paint = new int[n][k];
//        for (int j = 0;j<k ;j++ ) {
//            paint[0][j] = a[0][j];
//        }
//        for (int i=1;i<a.length ;i++ ) {
//            for (int j=0;j<a[0].length ;j++ ) {
//                int min = Integer.MAX_VALUE;
//                for (int x=0;x<a[0].length ;x++ ) {
//                    if(j!=x){
//                        if(paint[i-1][x]<min){
//                            min = paint[i-1][x];
//                        }
//                    }
//                }
//                paint[i][j] = min+a[i][j];
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i=0;i<a.length ;i++ ) {
//            if(paint[i][k-1]<min){
//                min= paint[i][k-1];
//            }
//        }
//        System.out.println(min);


        // N2 ka tareekaaa //


        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        int[][] paint = new int[n][k];
        for (int j = 0;j<k ;j++ ) {
            paint[0][j] = a[0][j];
            if(a[0][j]<least){
                sleast=least;
                least=a[0][j];
            }else if(a[0][j]<sleast){
                sleast=a[0][j];
            }
        }

        for (int i=1;i<a.length ;i++ ) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j=0;j<a[0].length ;j++ ) {
                if(paint[i-1][j] == least ){
                    paint[i][j] = a[i][j] + sleast;
                }else{
                    paint[i][j] = a[i][j] + least;
                }
                if(paint[i][j]<nleast){
                    nsleast=nleast;
                    nleast=paint[i][j];
                }else if(paint[i][j]<nsleast){
                    nsleast=paint[i][j];
                }
            }
            least= nleast;
            sleast=nsleast;
        }
        System.out.println(least);
    }

}
