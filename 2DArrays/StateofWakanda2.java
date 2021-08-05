import java.util.Scanner;

public class StateofWakanda2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<n ;j++ ) {
                a[i][j]=scn.nextInt();
            }
        }
        int cnt = 1;
        int i=0;
        int j=0;
        while(cnt<=n){
            System.out.println(a[i][j]);
            if(j==n-1){
                i=0;
                j=cnt;
                cnt++;
            }else {
                i++;
                j++;
            }
        }
    }
}
