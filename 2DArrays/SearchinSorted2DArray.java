import java.util.Scanner;

public class SearchinSorted2DArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<n ;j++ ) {
                a[i][j]=scn.nextInt();
            }
        }
        int i=0;
        int j=n-1;
        int key = scn.nextInt();
        while (i<n && j>=0){

            if(a[i][j]==key){
                System.out.println(i);
                System.out.println(j);
                return;
            }
            if(a[i][j]>key){
                j--;
            }
            if(a[i][j]<key) {
                i++;
            }
        }
        System.out.println("Not Found");
    }
}
