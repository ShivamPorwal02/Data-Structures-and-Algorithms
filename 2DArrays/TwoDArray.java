import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<m ;j++ ) {
                a[i][j]=scn.nextInt();
            }
        }
        for (int i=0;i<a.length ;i++ ) {
            for (int j=0;j<a[0].length ;j++ ) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
