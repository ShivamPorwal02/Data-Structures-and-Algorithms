import java.util.Scanner;

public class SpiralDisplay {
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
        // Spiral Print
        int minr = 0;
        int minc = 0;
        int maxc = m-1;
        int maxr = n-1;
        int total = n*m;
        int cnt=0;
        while(cnt<total){
            // left wall
            for (int i=minr,j=minc;i<=maxr && cnt<total ;i++ ) {
                System.out.println(a[i][j]);
                cnt++;
            }
            minc++;
            // bottom wall
            for (int i=maxr,j=minc;j<=maxc && cnt<total ;j++ ) {
                System.out.println(a[i][j]);
                cnt++;
            }
            maxr--;
            //right wall
            for (int i=maxr,j=maxc;i>=minr && cnt<total ;i-- ) {
                System.out.println(a[i][j]);
                cnt++;
            }
            maxc--;
            // top wall
            for (int i=minr,j=maxc;j>=minc && cnt<total ;j-- ) {
                System.out.println(a[i][j]);
                cnt++;
            }
            minr++;
        }
    }
}
