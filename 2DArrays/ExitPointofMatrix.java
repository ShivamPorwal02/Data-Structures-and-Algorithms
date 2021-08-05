import java.util.Scanner;

public class ExitPointofMatrix {
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
        int i=0;
        int j=0;
        char drn = 'E';
        while((i<n && i>=0) && (j<n && j>=0)){
//            System.out.println(i+" "+j);
            if(drn=='E' && a[i][j]==1){
                drn='S';
                i++;
            }
            else if(drn=='E' && a[i][j]==0){
                j++;
            }
            else if (drn=='S' && a[i][j]==1) {
                drn='W';
                j--;
            }else if(drn=='S' && a[i][j]==0){
                i++;
            }
            else if (drn=='W' && a[i][j]==1) {
                drn='N';
                i--;
            }else if(drn=='W' && a[i][j]==0){
                j--;
            }
            else if (drn=='N' && a[i][j]==1) {
                drn='E';
                j++;
            }else {
                i--;
            }
        }
        System.out.println(i>=n?i-1:i);
        System.out.println(j>=n?j-1:j);
    }
}
