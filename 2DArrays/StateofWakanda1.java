import java.util.Scanner;

public class StateofWakanda1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<m ;j++ ) {
                a[i][j] = scn.nextInt();
            }
        }
        for (int i=0;i<m ;i++ ) {
            if(i%2==0){
                int j=0;
                while (j!=n){
                    System.out.println(a[j][i]);
                    j++;
                }
            }
            else {
                int j=n-1;
                while(j>=0){
                    System.out.println(a[j][i]);
                    j--;
                }
            }
        }
    }
}
