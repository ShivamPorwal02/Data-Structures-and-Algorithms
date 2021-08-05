import java.io.*;
import java.util.*;

public class ShellRotate {

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
        int s= scn.nextInt();
        int r=scn.nextInt();
        rotateshell(a,s,r);
        display(a);
    }
    public static void rotateshell(int[][] a,int s,int r){
        int[] oned = fillOnedfromShell(a,s);
        rotate(oned,r);
        fillShellfromOned(a,s,oned);
    }
    public static void reverse(int[] a,int l,int h){
        while (l<h){
            int temp = a[l];
            a[l]=a[h];
            a[h]=temp;
            l++;
            h--;
        }
    }
    public static void rotate(int[] oned,int r){
        r = r % oned.length;
        if(r<0){
            r=oned.length+r;
        }
        reverse(oned,0,oned.length-r-1);
        reverse(oned,oned.length-r,oned.length-1);
        reverse(oned,0,oned.length-1);
    }
    public static void fillShellfromOned(int[][] a,int s,int[] oned){
        int minr = s-1;
        int minc = s-1;
        int maxr =a.length-s;
        int maxc =a[0].length -s;
        int idx = 0;
        for (int i=minr,j=minc;i<=maxr ;i++ ) {
            a[i][j]=oned[idx];
            idx++;
        }
        for (int i=maxr,j=minc+1;j<=maxc ;j++ ) {
            a[i][j]=oned[idx];
            idx++;
        }
        for (int i=maxr-1,j=maxc;i>=minr ;i-- ) {
            a[i][j]=oned[idx];
            idx++;
        }
        for (int i=minr,j=maxc-1;j>=minc+1 ;j-- ) {
            a[i][j]=oned[idx];
            idx++;
        }
    }
    public static int[] fillOnedfromShell(int[][] a,int s){
        int minr = s-1;
        int minc = s-1;
        int maxr =a.length-s;
        int maxc =a[0].length -s;
        int sz = 2*(maxc-minc+maxr-minr);
        int[] oned = new int[sz];
        int idx = 0;
        for (int i=minr,j=minc;i<=maxr ;i++ ) {
            oned[idx]=a[i][j];
            idx++;
        }
        for (int i=maxr,j=minc+1;j<=maxc ;j++ ) {
            oned[idx]=a[i][j];
            idx++;
        }
        for (int i=maxr-1,j=maxc;i>=minr ;i-- ) {
            oned[idx]=a[i][j];
            idx++;
        }
        for (int i=minr,j=maxc-1;j>=minc+1 ;j-- ) {
            oned[idx]=a[i][j];
            idx++;
        }
        return oned;

    }
    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
