import java.util.Scanner;

public class Rotate90Degree {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<n ;j++ ) {
                a[i][j] = scn.nextInt();
            }
        }
        // IN-PLACE

        // Transpose
        for (int i=0;i<n ;i++ ) {
            for (int j=i;j<n ;j++ ) {
                int temp= a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
        // Reverse the columns
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<n/2 ;j++ ) {
                int temp=a[i][j];
                a[i][j]=a[i][n-j-1];
                a[i][n-j-1]=temp;
            }
        }



        for (int i=0;i<n;i++ ) {
            for (int j=0;j<n ;j++ ) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
