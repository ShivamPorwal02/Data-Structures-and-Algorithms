import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<n;j++){
                a[i][j]=scn.nextInt();
            }
        }
        int[] b = new int[n];
        int idx = 0;
        for (int i=0;i<n ;i++ ) {
            int min = Integer.MAX_VALUE;
            for (int j=0;j<n;j++){
                if(a[i][j]<min){
                    min=a[i][j];
                }
            }
            b[idx]=min;
            idx++;
        }
        for (int i=0;i<n ;i++ ) {
            int max = Integer.MIN_VALUE;
            for (int j=0;j<n ;j++ ) {
                if(a[j][i]>max){
                    max=a[j][i];
                }
            }
            for (int k=0;k<n ;k++) {
                if(max==b[k]){
                    System.out.println(b[k]);
                    return;
                }
            }
        }

    }
}
